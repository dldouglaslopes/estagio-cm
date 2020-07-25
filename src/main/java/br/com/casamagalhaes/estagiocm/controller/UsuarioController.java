package br.com.casamagalhaes.estagiocm.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.casamagalhaes.estagiocm.model.Usuario;
import br.com.casamagalhaes.estagiocm.service.UsuarioService;

@Resource
public class UsuarioController {

	private Result result;
    private Validator validator;
    private final String formatDate = "dd/mm/YYYY";
	
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
	public void salvar(Usuario usuario) throws ParseException {
//    	DateFormat df = new SimpleDateFormat(formatDate);
//    	String sDate = df.format(usuario.getData());
//    	usuario.setData(df.parse(sDate));
		usuarioService.salvar(usuario);
		result.include("mensagem", "Usuário adicionado com sucesso");
		result.redirectTo(this.getClass()).index();
	}

	@Get
	@Path("/pesquisar")
	public void pesquisar(Usuario usuario) {
		result.include("usuarioList", usuarioService.pesquisar(usuario));
		result.permanentlyRedirectTo("/");
	}
	
	@Transactional
	@Path("/delete/{id}")
	public void delete(Long id) {
		usuarioService.remove(id);
		result.redirectTo(this.getClass()).index();
	}
	
	@Transactional
	@Put
	@Path("/editar")
	public void editar(Usuario usuario) {
		usuarioService.editar(usuario);
		result.redirectTo(this.getClass()).index();
	}
	
	@Get
	@Path("/editar/{id}")
	public Usuario view(Long id) {
		return usuarioService.pesquisar(id);
	}
}
