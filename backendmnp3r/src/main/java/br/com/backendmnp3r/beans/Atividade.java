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
@Table (name = "itmn232_atividade")

public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idatividade")
	private int idatividade;
	
	@Column(name="nomeatividade", length=100)
	private String nomeatividade;
	
	@JsonIgnoreProperties("idatividade")
	@OneToMany(mappedBy ="idatividade", cascade =CascadeType.ALL) 
	private List<Ocorrencia> atvocorrencias;
	//devemos atualizar o constructor?
	
	
	
	

	public int getIdatividade() {
		return idatividade;
	}

	public List<Ocorrencia> getAtvocorrencias() {
		return atvocorrencias;
	}

	public void setAtvocorrencias(List<Ocorrencia> atvocorrencias) {
		this.atvocorrencias = atvocorrencias;
	}

	public void setIdatividade(int idatividade) {
		this.idatividade = idatividade;
	}

	public String getNomeatividade() {
		return nomeatividade;
	}

	public void setNomeatividade(String nomeatividade) {
		this.nomeatividade = nomeatividade;
	}

	public Atividade(int idatividade, String nomeatividade) {
		super();
		this.idatividade = idatividade;
		this.nomeatividade = nomeatividade;
	}

	public Atividade() {
		super();
	}
	
	
	
}
