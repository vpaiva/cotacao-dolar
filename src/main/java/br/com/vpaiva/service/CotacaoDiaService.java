package br.com.vpaiva.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.vpaiva.client.BCBClient;
import br.com.vpaiva.client.request.CotacaoDiaRequest;
import br.com.vpaiva.client.response.CotacaoDiaResponse;
import br.com.vpaiva.client.response.CotacaoValueDTO;
import br.com.vpaiva.model.CotacaoDolar;
import br.com.vpaiva.repository.CotacaoDolarRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Traced
public class CotacaoDiaService {

  private static final Logger log = LoggerFactory.getLogger(CotacaoDiaService.class);

  private final BCBClient bcbClient;
  private final CotacaoDolarRepository cotacaoDolarRepository;

  public CotacaoDiaService(@RestClient BCBClient bcbClient,
      CotacaoDolarRepository cotacaoDolarRepository) {
    this.bcbClient = bcbClient;
    this.cotacaoDolarRepository = cotacaoDolarRepository;
  }

  public Uni<CotacaoValueDTO> getCotacaoDia(String dataCotacao) {
    log.debug("Call bcbClient getCotacaoDolarDia. request: {}", dataCotacao);

    return bcbClient.getCotacaoDolarDia(new CotacaoDiaRequest(dataCotacao))
        .map(this::toCotacaoValue)
        .invoke(
            response -> log.debug("Call bcbClient getCotacaoDolarDia. response: {}", dataCotacao))
        .invoke(cotacaoValue -> saveRequest(dataCotacao, cotacaoValue)).onFailure()
        .invoke(ex -> log.error("Call bcbClient getCotacaoDolarDia error.", ex));
  }

  CotacaoValueDTO toCotacaoValue(CotacaoDiaResponse cotacaodiaresponse) {
    Set<CotacaoValueDTO> cotacoes = cotacaodiaresponse.getValue();

    if (!cotacoes.isEmpty()) {
      return cotacoes.iterator().next();
    }

    return null;
  }

  @Transactional
  void saveRequest(String dataCotacao, CotacaoValueDTO cotacaoValueDTO) {
    if (Objects.isNull(dataCotacao) || Objects.isNull(cotacaoValueDTO)) {
      return;
    }

    CotacaoDolar cotacaoDolar =
        new CotacaoDolar(LocalDate.parse(dataCotacao, DateTimeFormatter.ofPattern("MM-dd-yyyy")),
            cotacaoValueDTO.getCotacaoCompra(), cotacaoValueDTO.getCotacaoVenda(),
            LocalDateTime.parse(cotacaoValueDTO.getDataHoraCotacao(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

    cotacaoDolarRepository.persist(cotacaoDolar);
  }

}
