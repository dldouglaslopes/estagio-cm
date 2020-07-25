package br.com.casamagalhaes.estagiocm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.casamagalhaes.estagiocm.model.Usuario;
import br.com.casamagalhaes.estagiocm.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean salvar(Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Nenhuma propriedade informada");
		}
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> listar(String query) {
		return usuarioRepository.listar(query);
	}

	@Override
	public List<Usuario> pesquisar(Usuario usuario) {
		return usuarioRepository.pesquisar(usuario);
	}

	@Override
	public void remove(Long id) {
		usuarioRepository.remove(id);
	}

	@Override
	public void editar(Usuario usuario) {
		usuarioRepository.editar(usuario);
	}

	@Override
	public Usuario pesquisar(Long id) {
		
		return usuarioRepository.pesquisar(id);
	}
	
	
}
