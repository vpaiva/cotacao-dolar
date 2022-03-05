package br.com.vpaiva.repository;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.opentracing.Traced;
import br.com.vpaiva.model.CotacaoDolar;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
@Traced
public class CotacaoDolarRepository implements PanacheRepository<CotacaoDolar> {
}
