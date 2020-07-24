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
import br.com.caelum.vraptor.view.Results;
import br.com.casamagalhaes.estagiocm.model.Estagiario;
import br.com.casamagalhaes.estagiocm.model.Usuario;
import br.com.casamagalhaes.estagiocm.service.EstagiarioService;
import br.com.casamagalhaes.estagiocm.service.UsuarioService;

@Resource
public class IndexController {

    private Result result;
    private Validator validator;

    @Autowired
    private EstagiarioService estagiarioService;
    @Autowired
    private UsuarioService usuarioService;

    public IndexController(Result result, Validator validator) {
        this.result = result;
        this.validator = validator;
    }

    @Get
    @Path("/greeting")
    @Transactional
    public void greeting(Estagiario estagiario) {
        estagiarioService.darBoasVindas(estagiario);
        result.use(Results.json()).from(estagiario).serialize();
        
    }
    
}
