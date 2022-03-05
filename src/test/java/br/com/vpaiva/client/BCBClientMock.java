package br.com.vpaiva.client;

import java.math.BigDecimal;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import br.com.vpaiva.client.request.CotacaoDiaRequest;
import br.com.vpaiva.client.response.CotacaoDiaResponse;
import br.com.vpaiva.client.response.CotacaoValueDTO;
import io.quarkus.test.Mock;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.UniCreate;

@Mock
@ApplicationScoped
@RestClient
public class BCBClientMock implements BCBClient {

  public static final CotacaoValueDTO COTACAO_VALUE_DTO = new CotacaoValueDTO(
      new BigDecimal("5.04730"), new BigDecimal("5.04790"), "2022-03-03 13:04:52.092");

  @Override
  public Uni<CotacaoDiaResponse> getCotacaoDolarDia(CotacaoDiaRequest cotacaoDiaRequest) {
    UniCreate uniCreate = Uni.createFrom();

    if ("\'03-03-2022\'".equals(cotacaoDiaRequest.getDataCotacao())) {
      return uniCreate.item(new CotacaoDiaResponse(Set.of(COTACAO_VALUE_DTO)));
    }

    return uniCreate.item(new CotacaoDiaResponse());
  }

}
