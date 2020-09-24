package br.com.backendmnp3r.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.backendmnp3r.beans.Ocorrencia;

public interface OcorrenciaDAO extends CrudRepository<Ocorrencia, Integer> {

	ArrayList<Ocorrencia> findByStatus(int status);
}
