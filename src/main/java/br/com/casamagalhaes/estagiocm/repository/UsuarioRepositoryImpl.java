package br.com.casamagalhaes.estagiocm.repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.casamagalhaes.estagiocm.model.Usuario;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public void save(Usuario usuario) {
		entityManager.persist(usuario);	
	}

	@Override
	public List<Usuario> pesquisar(Usuario usuario) {
		Criteria c = ((Session)entityManager.getDelegate()).createCriteria(Usuario.class);
		
		if(Objects.nonNull(usuario.getNome())) {
			c.add(Restrictions.ilike("nome", usuario.getNome(), MatchMode.ANYWHERE));
		}
		
		if(Objects.nonNull(usuario.getData())) {
			c.equals(usuario.getData());
		}

        return c.list();
	}

	@Override
	public List<Usuario> listar(String query) {
		return entityManager.createQuery(query, Usuario.class).getResultList();
	}

	@Override
	public void remove(Long id) {
		Usuario u = entityManager.find(Usuario.class, id);
		entityManager.remove(u);
	}
}
