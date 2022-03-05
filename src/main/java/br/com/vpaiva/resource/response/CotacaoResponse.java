package br.com.vpaiva.resource.response;

import java.math.BigDecimal;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;

@Schema(description = "Dados da cotação")
public class CotacaoResponse {

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @Schema(description = "Valor da cotação na compra", example = "5.04730")
  private BigDecimal cotacaoCompra;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @Schema(description = "Valor da cotação na venda", example = "5.04790")
  private BigDecimal cotacaoVenda;

  @Schema(description = "Data e Hora que foi realizada a cotação",
      example = "2022-03-03 13:04:52.092")
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
