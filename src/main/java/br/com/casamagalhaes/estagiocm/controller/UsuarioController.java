package br.com.casamagalhaes.estagiocm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.casamagalhaes.estagiocm.model.Usuario;
import br.com.casamagalhaes.estagiocm.service.UsuarioService;

@Resource
public class UsuarioController {

	private Result result;
    private Validator validator;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController(Result result, Validator validator) {
        this.result = result;
        this.validator = validator;
    }
	
	@Get
    @Path("/")
    public List<Usuario> index() {
        String query = "SELECT u FROM usuario u ORDER BY u.nome";
        result.include("usuarioList", usuarioService.listar(query));
		return usuarioService.listar(query);
    }

	
	@Transactional
    @Post
	@Path("/salvar")
	public void salvar(Usuario usuario) {
    	//System.out.println(usuario.getData());
		usuarioService.salvar(usuario);
		result.include("mensagem", "Usuário adicionado com sucesso");
		result.redirectTo(this.getClass()).index();
	}

	@Get
	@Path("/pesquisar")
	public List<Usuario> pesquisar(Usuario usuario) {
		//result.include("usuarioList", usuarioService.pesquisar(usuario));
		return usuarioService.pesquisar(usuario);
	}
	
	@Transactional
	@Path("/delete/{id}")
	public void delete(Long id) {
		usuarioService.remove(id);
		result.redirectTo(this.getClass()).index();
	}
}
