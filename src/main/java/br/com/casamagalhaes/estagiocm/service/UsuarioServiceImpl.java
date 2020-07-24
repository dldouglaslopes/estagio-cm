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
	public String salvar(Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Nenhuma propriedade informada");
		}
		usuarioRepository.save(usuario);
		
		return usuario.getNome();
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
	
	
}
