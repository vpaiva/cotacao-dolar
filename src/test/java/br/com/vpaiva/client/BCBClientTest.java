package br.com.vpaiva.client;

import static br.com.vpaiva.client.BCBClientMock.COTACAO_VALUE_DTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import br.com.vpaiva.client.request.CotacaoDiaRequest;
import br.com.vpaiva.client.response.CotacaoDiaResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;

@QuarkusTest
class BCBClientTest {

  @Inject
  @RestClient
  BCBClient bcbClient;

  @Test
  void testGetCotacaoDolarDia() {
    CotacaoDiaRequest request = new CotacaoDiaRequest("03-03-2022");

    CotacaoDiaResponse expected = new CotacaoDiaResponse(Set.of(COTACAO_VALUE_DTO));

    bcbClient.getCotacaoDolarDia(request).subscribe().withSubscriber(UniAssertSubscriber.create())
        .awaitItem().assertItem(expected).assertCompleted();

  }

  @Test
  void testGetCotacaoDolarDiaNaoUtil() {
    CotacaoDiaRequest request = new CotacaoDiaRequest("02-27-2022");

    CotacaoDiaResponse expected = new CotacaoDiaResponse();

    bcbClient.getCotacaoDolarDia(request).subscribe().withSubscriber(UniAssertSubscriber.create())
        .awaitItem().assertItem(expected).assertCompleted();

  }

  @Test
  void testGetCotacaoDolarDiaFuturo() {
    CotacaoDiaRequest request = new CotacaoDiaRequest(
        LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));

    CotacaoDiaResponse expected = new CotacaoDiaResponse();

    bcbClient.getCotacaoDolarDia(request).subscribe().withSubscriber(UniAssertSubscriber.create())
        .awaitItem().assertItem(expected).assertCompleted();

  }
}
