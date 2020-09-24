package br.com.backendmnp3r.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.backendmnp3r.beans.Usuario;
import br.com.backendmnp3r.dao.UsuarioDAO;

@CrossOrigin("*") 
@RestController

public class UsuarioController {
	
	@Autowired 
	private UsuarioDAO dao;
	
	@PostMapping("/login") 
	public ResponseEntity<Usuario> logar(@RequestBody Usuario user) //requestbody capta usuario e senha do html
	{
		Usuario resposta = dao.findByRacfAndSenha(user.getRacf(), user.getSenha());
		
		if (resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	

}
