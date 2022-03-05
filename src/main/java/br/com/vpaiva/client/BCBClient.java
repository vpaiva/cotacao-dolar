package br.com.vpaiva.client;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import br.com.vpaiva.client.request.CotacaoDiaRequest;
import br.com.vpaiva.client.response.CotacaoDiaResponse;
import io.smallrye.mutiny.Uni;

@RegisterRestClient(configKey = "bcb-client")
@Traced
public interface BCBClient {

  @GET
  @Path("CotacaoDolarDia(dataCotacao=@dataCotacao)")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  Uni<CotacaoDiaResponse> getCotacaoDolarDia(@BeanParam CotacaoDiaRequest cotacaoDiaRequest);
}
