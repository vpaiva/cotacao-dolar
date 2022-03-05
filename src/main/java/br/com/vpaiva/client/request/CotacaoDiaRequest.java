package br.com.vpaiva.client.request;

import javax.ws.rs.QueryParam;

public class CotacaoDiaRequest {

  @QueryParam("@dataCotacao")
  private String dataCotacao;

  public CotacaoDiaRequest(String dataCotacao) {
    this.dataCotacao = "\'" + dataCotacao + "\'";
  }

  public String getDataCotacao() {
    return dataCotacao;
  }

}
