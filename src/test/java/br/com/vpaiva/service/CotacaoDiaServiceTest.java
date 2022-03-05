package br.com.vpaiva.service;

import static br.com.vpaiva.client.BCBClientMock.COTACAO_VALUE_DTO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import br.com.vpaiva.client.response.CotacaoDiaResponse;
import br.com.vpaiva.client.response.CotacaoValueDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;

@QuarkusTest
class CotacaoDiaServiceTest {

  @Inject
  CotacaoDiaService cotacaoDiaService;

  @Test
  void testToCotacaoValue() {
    CotacaoDiaResponse cotacaoDiaResponse = new CotacaoDiaResponse(Set.of(COTACAO_VALUE_DTO));
    CotacaoValueDTO received = cotacaoDiaService.toCotacaoValue(cotacaoDiaResponse);

    Assertions.assertEquals(COTACAO_VALUE_DTO, received);
  }

  @Test
  void testToCotacaoValueNull() {
    CotacaoDiaResponse cotacaoDiaResponse = new CotacaoDiaResponse();
    CotacaoValueDTO received = cotacaoDiaService.toCotacaoValue(cotacaoDiaResponse);

    Assertions.assertNull(received);
  }

  @Test
  void testGetCotacaoDia() {
    cotacaoDiaService.getCotacaoDia("03-03-2022").subscribe()
        .withSubscriber(UniAssertSubscriber.create()).awaitItem().assertItem(COTACAO_VALUE_DTO)
        .assertCompleted();
  }

  @Test
  void testGetCotacaoDolarDiaNaoUtil() {
    cotacaoDiaService.getCotacaoDia("02-27-2022").subscribe()
        .withSubscriber(UniAssertSubscriber.create()).awaitItem().assertItem(null)
        .assertCompleted();

  }

  @Test
  void testGetCotacaoDolarDiaFuturo() {
    cotacaoDiaService
        .getCotacaoDia(
            LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("MM-dd-yyyy")))
        .subscribe().withSubscriber(UniAssertSubscriber.create()).awaitItem().assertItem(null)
        .assertCompleted();

  }
}
