package br.com.casamagalhaes.estagiocm.repository;

import br.com.casamagalhaes.estagiocm.model.Estagiario;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EstagiarioRepositoryImpl implements EstagiarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Estagiario estagiario) {
        entityManager.persist(estagiario);
    }

    @Override
    public Estagiario pesquisar(Estagiario estagiario) {
        Criteria c = ((Session)entityManager.getDelegate()).createCriteria(Estagiario.class);
        c.add(Restrictions.ilike("nome", estagiario.getNome(), MatchMode.ANYWHERE));

        return (Estagiario) c.uniqueResult();
    }
}
