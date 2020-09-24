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
import br.com.backendmnp3r.dao.OcorrenciaDAO;
@CrossOrigin("*")
@RestController

public class OcorrenciaController {
	
	@Autowired
	private OcorrenciaDAO dao;
	
	@GetMapping("/ocorrencias")
	public ResponseEntity <ArrayList<Ocorrencia>> getAll(){
		ArrayList<Ocorrencia> lista = (ArrayList<Ocorrencia>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/ocorrencias/{id}")
	public ResponseEntity <Ocorrencia> getMusica(@PathVariable int id) {
		Ocorrencia resp = dao.findById(id).orElse(null);
		if(resp == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/status/{stat}")
	public ResponseEntity<ArrayList<Ocorrencia>> getOcorrencia(@PathVariable int stat)
	{
		ArrayList<Ocorrencia> resultado = dao.findByStatus(stat);
		if (resultado.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping("/gravarcorrencia")
	public ResponseEntity<Ocorrencia> gravar (@RequestBody Ocorrencia ocorrencia){
		try {
			Ocorrencia resposta = dao.findById(ocorrencia.getNumseq()).orElse(null);
			resposta.setIdatividade(ocorrencia.getIdatividade());
			resposta.setDescricao(ocorrencia.getDescricao());
			resposta.setPontomanual(ocorrencia.getPontomanual());
			resposta.setStatus(ocorrencia.getStatus());
			
			dao.save(resposta);
			return ResponseEntity.ok(resposta);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
}
