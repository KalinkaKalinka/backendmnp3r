package br.com.backendmnp3r.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.backendmnp3r.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>  {

	Usuario findByRacfAndSenha(String ra, String se);
}
