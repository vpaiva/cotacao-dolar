package br.com.vpaiva.resource.mapper;

import org.mapstruct.Mapper;
import br.com.vpaiva.client.response.CotacaoValueDTO;
import br.com.vpaiva.resource.response.CotacaoResponse;

@Mapper
public interface CotacaoMapper {

  CotacaoResponse toCotacaoResponse(CotacaoValueDTO cotacaovalue);
}
