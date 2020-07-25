package br.com.casamagalhaes.estagiocm.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.casamagalhaes.estagiocm.data.Criptografia;
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
    @Path("/index")
    public List<Usuario> index(Boolean searchByFilters, Usuario ...usuario) {
		if(Objects.nonNull(searchByFilters) && searchByFilters) {
			result.include("usuarioList", usuarioService.pesquisar(usuario[0]));
			return usuarioService.pesquisar(usuario[0]);
		}else {
			String query = "SELECT u FROM usuario u ORDER BY u.nome";
	        result.include("usuarioList", usuarioService.listar(query));
	        return usuarioService.listar(query);
		}
    }
	
	@Path("/")
	public void init() {
		
	}
	
	@Post
	@Path("/login")
	public void login(Usuario usuario) throws NoSuchAlgorithmException {
		List<Usuario> usuarios = usuarioService.pesquisar(usuario);
		if (usuarios.size() > 0) {
			Criptografia criptografia = new Criptografia();
			String criptografado = criptografia.criptografarMD5(usuario);
			
			if (!usuarios.get(0).getSenha().equals(criptografado)) {
				result.redirectTo(this.getClass()).init();
			}
			else {
				result.include("mensagem", "Seja bem-vindo " + usuarios.get(0).getNome() + "!");
				result.redirectTo(this.getClass()).index(false);
			}
		}
		else {
			result.redirectTo(this.getClass()).init();
		}
	}
	
	@Transactional
    @Post
	@Path("/salvar")
	public void salvar(Usuario usuario) throws Exception {
		boolean adicionado = usuarioService.salvar(usuario);
		if (adicionado) {
			result.include("adicionado", "Usuário adicionado com sucesso");
		}
		else {
			result.include("adicionado", "Usuário com cpf existente");
		}
		result.redirectTo(this.getClass()).index(false);
	}

	@Transactional
	@Get
	@Path("/pesquisar")
	public void pesquisar(Usuario usuario) {
		result.redirectTo(this.getClass()).index(true, usuario);
	}
	
	@Transactional
	@Path("/delete/{id}")
	public void delete(Long id) {
		usuarioService.remove(id);
		result.redirectTo(this.getClass()).index(false);
	}
	
	@Transactional
	@Put
	@Path("/editar")
	public void editar(Usuario usuario) {
		usuarioService.editar(usuario);
		result.redirectTo(this.getClass()).index(false);
	}
	
	@Get
	@Path("/editar/{id}")
	public Usuario view(Long id) {
		return usuarioService.pesquisar(id);
	}
}
