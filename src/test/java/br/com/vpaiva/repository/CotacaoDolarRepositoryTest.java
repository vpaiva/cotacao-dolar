package br.com.vpaiva.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import br.com.vpaiva.model.CotacaoDolar;

@TransactionalQuarkusTest
class CotacaoDolarRepositoryTest {

  private static final BigDecimal DATA_VENDA = new BigDecimal("5.04790");
  private static final BigDecimal DATA_COMPRA = new BigDecimal("5.04730");
  private static final LocalDate DATA_COTACAO = LocalDate.of(2022, 03, 03);
  @Inject
  CotacaoDolarRepository cotacaoDolarRepository;

  @Test
  void testAdd() {
    LocalDateTime now = LocalDateTime.now();

    CotacaoDolar cotacaoDolar = new CotacaoDolar(DATA_COTACAO, DATA_COMPRA, DATA_VENDA, now);
    cotacaoDolarRepository.persist(cotacaoDolar);

    Assertions.assertTrue(cotacaoDolar.getId() >= 1L);
    Assertions.assertTrue(cotacaoDolar.getTimestamp().before(new Date()));
    Assertions.assertEquals(DATA_COTACAO, cotacaoDolar.getDataCotacao());
    Assertions.assertEquals(DATA_COMPRA, cotacaoDolar.getCotacaoCompra());
    Assertions.assertEquals(DATA_VENDA, cotacaoDolar.getCotacaoVenda());
    Assertions.assertEquals(now, cotacaoDolar.getDataHoraCotacao());

  }
}
