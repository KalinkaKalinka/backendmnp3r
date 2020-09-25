package br.com.backendmnp3r.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.backendmnp3r.beans.Ocorrencia;
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
	
	@GetMapping("/ocorrenciasusuario/{user}")
	public ResponseEntity<Usuario> getOcorrencia(@PathVariable int user)
	{
		Usuario resultado = dao.findById(user).orElse(null);
		if (resultado == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resultado);
	}

}
