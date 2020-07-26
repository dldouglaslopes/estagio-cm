package br.com.casamagalhaes.estagiocm.repository;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.casamagalhaes.estagiocm.data.Criptografia;
import br.com.casamagalhaes.estagiocm.model.Usuario;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public boolean save(Usuario usuario) throws NoSuchAlgorithmException {
		if (findByCpf(usuario.getCpf())) {
			return false;
		}
		
		entityManager.persist(usuario);
		return true;
	}

	@Override
	public List<Usuario> pesquisar(Usuario usuario) {
		String queryStr = "SELECT u FROM usuario u ";
		
		if (Objects.nonNull(usuario.getCpf()) || Objects.nonNull(usuario.getNome())) {
			if (Objects.nonNull(usuario.getCpf()) && Objects.isNull(usuario.getNome())) {
				queryStr += "WHERE u.cpf='" + usuario.getCpf() + "'";
			}
			else if(Objects.isNull(usuario.getCpf()) && Objects.nonNull(usuario.getNome())){
				queryStr += "WHERE u.nome LIKE '%" + usuario.getNome() + "%'";
			}
			else {
				queryStr += "WHERE u.cpf='" + usuario.getCpf() + "' AND u.nome LIKE '%" + usuario.getNome() + "%'";
			}
		}

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

	@Override
	public boolean findByCpf(String cpf) {
		String queryStr = "SELECT u FROM usuario u WHERE u.cpf='" + cpf + "'";
		Query query = entityManager.createQuery(queryStr);
		
		if(query.getResultList().isEmpty()) {
			return false;
		}else {
			return true;
		}
		
	}
}
