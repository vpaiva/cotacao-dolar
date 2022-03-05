package br.com.vpaiva.client.response;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoDiaResponse implements Serializable {

  private static final long serialVersionUID = 5693469813168966108L;

  private Set<CotacaoValueDTO> value = Set.of();

  public CotacaoDiaResponse() {}

  public CotacaoDiaResponse(Set<CotacaoValueDTO> value) {
    this.value = value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CotacaoDiaResponse other = (CotacaoDiaResponse) obj;
    return Objects.equals(value, other.value);
  }

  public Set<CotacaoValueDTO> getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "CotacaoDiaResponse [value=" + value + "]";
  }
}
