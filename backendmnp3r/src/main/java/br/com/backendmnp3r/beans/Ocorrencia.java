package br.com.backendmnp3r.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "itmn232_ocorrencia")
public class Ocorrencia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="numseq")
	private int numseq;
	

	@JsonIgnoreProperties("ocorrencias")
	@ManyToOne
	private Usuario idusuario;
	
	@JsonIgnoreProperties("atvocorrencias")
	@ManyToOne
	private Atividade idatividade;
	
	@Column(name ="descricao", length=255)
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy") //formata a data
	@Column (name="dataoc")
	@Temporal(TemporalType.DATE)
	private Date dataoc;
	
	@Column(name ="numhoras", length=20)
	private String numhoras;
	
	@Column(name ="pontomanual")
	private int pontomanual;
	
	@Column(name ="status")
	private int status;

	public int getNumseq() {
		return numseq;
	}

	public void setNumseq(int numseq) {
		this.numseq = numseq;
	}

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	public Atividade getIdatividade() {
		return idatividade;
	}

	public void setIdatividade(Atividade idatividade) {
		this.idatividade = idatividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataoc() {
		return dataoc;
	}

	public void setDataoc(Date dataoc) {
		this.dataoc = dataoc;
	}

	public String getNumhoras() {
		return numhoras;
	}

	public void setNumhoras(String numhoras) {
		this.numhoras = numhoras;
	}

	public int getPontomanual() {
		return pontomanual;
	}

	public void setPontomanual(int pontomanual) {
		this.pontomanual = pontomanual;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Ocorrencia(int numseq, Usuario idusuario, Atividade idatividade, String descricao, Date dataoc,
			String numhoras, int pontomanual, int status) {
		super();
		this.numseq = numseq;
		this.idusuario = idusuario;
		this.idatividade = idatividade;
		this.descricao = descricao;
		this.dataoc = dataoc;
		this.numhoras = numhoras;
		this.pontomanual = pontomanual;
		this.status = status;
	}

	public Ocorrencia() {
		super();
	}
	
	
	
	
	
	

}
