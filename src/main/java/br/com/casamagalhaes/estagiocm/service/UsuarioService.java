package br.com.casamagalhaes.estagiocm.service;

import java.util.List;

import br.com.casamagalhaes.estagiocm.model.Usuario;

public interface UsuarioService {

	public boolean salvar(Usuario usuario) throws Exception;

	public List<Usuario> listar(String query);
	
	public List<Usuario> pesquisar(Usuario usuario);

	public void remove(Long id);

	public void editar(Usuario usuario);

	public Usuario pesquisar(Long id);
}
