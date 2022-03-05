package br.com.vpaiva.client.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoValueDTO implements Serializable {

  private static final long serialVersionUID = 5827727512537804790L;

  private BigDecimal cotacaoCompra;
  private BigDecimal cotacaoVenda;
  private String dataHoraCotacao;

  public CotacaoValueDTO() {}

  public CotacaoValueDTO(BigDecimal cotacaoCompra, BigDecimal cotacaoVenda,
      String dataHoraCotacao) {
    this.cotacaoCompra = cotacaoCompra;
    this.cotacaoVenda = cotacaoVenda;
    this.dataHoraCotacao = dataHoraCotacao;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cotacaoCompra, cotacaoVenda, dataHoraCotacao);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CotacaoValueDTO other = (CotacaoValueDTO) obj;
    return Objects.equals(cotacaoCompra, other.cotacaoCompra)
        && Objects.equals(cotacaoVenda, other.cotacaoVenda)
        && Objects.equals(dataHoraCotacao, other.dataHoraCotacao);
  }

  public BigDecimal getCotacaoCompra() {
    return cotacaoCompra;
  }

  public BigDecimal getCotacaoVenda() {
    return cotacaoVenda;
  }

  public String getDataHoraCotacao() {
    return dataHoraCotacao;
  }

  @Override
  public String toString() {
    return "CotacaoValueDTO [cotacaoCompra=" + cotacaoCompra + ", cotacaoVenda=" + cotacaoVenda
        + ", dataHoraCotacao=" + dataHoraCotacao + "]";
  }
}
