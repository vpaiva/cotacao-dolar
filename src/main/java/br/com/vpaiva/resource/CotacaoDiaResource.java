package br.com.vpaiva.resource;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestQuery;
import br.com.vpaiva.resource.mapper.CotacaoMapper;
import br.com.vpaiva.resource.response.CotacaoResponse;
import br.com.vpaiva.service.CotacaoDiaService;
import io.smallrye.mutiny.Uni;

@Path("/v1/cotacao")
public class CotacaoDiaResource {

  private final CotacaoDiaService cotacaoDiaService;
  private final CotacaoMapper cotacaoMapper;

  public CotacaoDiaResource(CotacaoDiaService cotacaoDiaService, CotacaoMapper cotacaoMapper) {
    this.cotacaoDiaService = cotacaoDiaService;
    this.cotacaoMapper = cotacaoMapper;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @ResponseStatus(200)
  @Operation(description = "Retornar a cotação de determinada data")
  @APIResponse(responseCode = "200", description = "Sucesso")
  @APIResponse(responseCode = "400", description = "Bad Request")
  @Transactional
  public Uni<CotacaoResponse> getCotacao(
      @RestQuery @NotEmpty(message = "dataCotacao não pode ser nulo.") @Schema(
          description = "Data da cotação", example = "03-03-2022") String dataCotacao) {
    return cotacaoDiaService.getCotacaoDia(dataCotacao).map(cotacaoMapper::toCotacaoResponse);
  }

}
