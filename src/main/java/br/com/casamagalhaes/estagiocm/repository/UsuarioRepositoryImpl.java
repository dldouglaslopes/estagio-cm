package br.com.casamagalhaes.estagiocm.repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	private Session session;
	
	@Override
	public void save(Usuario usuario) {
		entityManager.persist(usuario);	
	}

	@Override
	public List<Usuario> pesquisar(Usuario usuario) {
		String queryStr = "SELECT u FROM usuario u where u.nome like '%" + usuario.getNome() + "%' ORDER BY u.nome";
		Query query = entityManager.createQuery(queryStr);
		
        return query.getResultList();
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

	@Override
	public void editar(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public Usuario pesquisar(Long id) {
		return entityManager.find(Usuario.class, id);
	}
}
