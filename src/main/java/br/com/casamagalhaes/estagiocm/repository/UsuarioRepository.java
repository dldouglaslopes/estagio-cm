package br.com.casamagalhaes.estagiocm.repository;

import java.util.List;

import br.com.casamagalhaes.estagiocm.model.Usuario;

public interface UsuarioRepository {
	
	public boolean save(Usuario usuario);
	
	public List<Usuario> pesquisar(Usuario usuario);
	
	public List<Usuario> listar(String query);

	public void remove(Long id);

	public void editar(Usuario usuario);
	
	public Usuario pesquisar(Long id);
	
	public boolean findByCpf(String cpf);
}
