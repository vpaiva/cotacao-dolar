package br.com.vpaiva.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.emptyOrNullString;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.core.Response.Status;
import org.junit.jupiter.api.Test;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(CotacaoDiaResource.class)
class CotacaoDolarResourceTest {

  @Test
  void testGetCotacaoEndpoint() {
    given().when().queryParam("dataCotacao", "03-03-2022").get().then().statusCode(200)
        .body("cotacaoCompra", is("5.04730")).body("cotacaoVenda", is("5.04790"))
        .body("dataHoraCotacao", is("2022-03-03 13:04:52.092"));
  }

  @Test
  void testGetCotacaoEndpointDiaNaoUtil() {
    given().when().queryParam("dataCotacao", "27-02-2022").get().then().statusCode(200)
        .body(emptyOrNullString());
  }

  @Test
  void testGetCotacaoEndpointDiaFuturo() {
    given().when()
        .queryParam("dataCotacao",
            LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("MM-dd-yyyy")))
        .get().then().statusCode(200).body(emptyOrNullString());
  }

  @Test
  void testGetCotacaoEndpointRequiredQueryParam() {
    given().when().get().then().statusCode(Status.BAD_REQUEST.getStatusCode())
        .body(is("dataCotacao não pode ser nulo."));
  }

}
