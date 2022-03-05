package br.com.vpaiva.resource.response;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CotacaoResponse {

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal cotacaoCompra;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private BigDecimal cotacaoVenda;

  private String dataHoraCotacao;

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

  public String getDataHoraCotacao() {
    return dataHoraCotacao;
  }

  public void setDataHoraCotacao(String dataHoraCotacao) {
    this.dataHoraCotacao = dataHoraCotacao;
  }

}
