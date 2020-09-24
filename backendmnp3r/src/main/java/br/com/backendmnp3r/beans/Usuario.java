package br.com.backendmnp3r.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "itmn232_usuario")

public class Usuario {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="id")
private int id;

@Column(name ="nome", length=100)
private String nome;

@Column(name ="email", length=100)
private String email;

@Column(name ="racf", length=7)
private String racf;

@Column(name ="senha", length=50)
private String senha;

@Column(name ="linkfoto", length=255)
private String linkfoto;

@Column(name ="gestor")
private int gestor;

@JsonIgnoreProperties("idusuario")
@OneToMany(mappedBy ="idusuario", cascade =CascadeType.ALL) 
private List<Ocorrencia> ocorrencias;
//devemos atualizar o constructor?

public List<Ocorrencia> getOcorrencias() {
	return ocorrencias;
}

public void setOcorrencias(List<Ocorrencia> ocorrencias) {
	this.ocorrencias = ocorrencias;
}

public Usuario() {
	super();
}

public Usuario(int id, String nome, String email, String racf, String senha, String linkfoto, int gestor) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.racf = racf;
	this.senha = senha;
	this.linkfoto = linkfoto;
	this.gestor = gestor;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getRacf() {
	return racf;
}

public void setRacf(String racf) {
	this.racf = racf;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getLinkfoto() {
	return linkfoto;
}

public void setLinkfoto(String linkfoto) {
	this.linkfoto = linkfoto;
}

public int getGestor() {
	return gestor;
}

public void setGestor(int gestor) {
	this.gestor = gestor;
}




}
