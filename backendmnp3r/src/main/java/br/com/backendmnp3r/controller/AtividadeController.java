package br.com.backendmnp3r.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backendmnp3r.beans.Atividade;
import br.com.backendmnp3r.dao.AtividadeDAO;

@CrossOrigin("*")
@RestController

public class AtividadeController {

	@Autowired
	private AtividadeDAO dao;
	
	@GetMapping("/atividades")
	public ResponseEntity <ArrayList<Atividade>> getAll(){
		ArrayList<Atividade> lista = (ArrayList<Atividade>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
}
