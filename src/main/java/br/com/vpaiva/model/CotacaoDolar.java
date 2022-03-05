package br.com.vpaiva.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class CotacaoDolar {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Timestamp timestamp;
  private LocalDate dataCotacao;
  private BigDecimal cotacaoCompra;
  private BigDecimal cotacaoVenda;
  private LocalDateTime dataHoraCotacao;

  public CotacaoDolar() {}

  public CotacaoDolar(LocalDate dataCotacao, BigDecimal cotacaoCompra, BigDecimal cotacaoVenda,
      LocalDateTime dataHoraCotacao) {
    this.dataCotacao = dataCotacao;
    this.cotacaoCompra = cotacaoCompra;
    this.cotacaoVenda = cotacaoVenda;
    this.dataHoraCotacao = dataHoraCotacao;
  }

  public Long getId() {
    return id;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public LocalDate getDataCotacao() {
    return dataCotacao;
  }

  public void setDataCotacao(LocalDate dataCotacao) {
    this.dataCotacao = dataCotacao;
  }

  public BigDecimal getCotacaoCompra() {
    return cotacaoCompra;
  }

  public void setCotacaoCompra(BigDecimal cotacaoCompra) {
    this.cotacaoCompra = cotacaoCompra;
  }

  public BigDecimal getCotacaoVenda() {
    return cotacaoVenda;
  }

  public void setCotacaoVenda(BigDecimal cotacaoVenda) {
    this.cotacaoVenda = cotacaoVenda;
  }

  public LocalDateTime getDataHoraCotacao() {
    return dataHoraCotacao;
  }

  public void setDataHoraCotacao(LocalDateTime dataHoraCotacao) {
    this.dataHoraCotacao = dataHoraCotacao;
  }

}
