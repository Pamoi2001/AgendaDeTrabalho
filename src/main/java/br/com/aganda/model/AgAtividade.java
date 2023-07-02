package br.com.aganda.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class AgAtividade implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ResponsavelAtividade responsavel;
		
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SituacaoAtividade situacao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PrioridadeAtividade prioridade;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	public AgAtividade() {
	}
	
	public AgAtividade(String titulo, String descricao, ResponsavelAtividade responsavel, SituacaoAtividade situacao,
			PrioridadeAtividade prioridade, Date deadline) {
			this.titulo = titulo;
			this.descricao = descricao;
			this.responsavel = responsavel;
			this.situacao = situacao;
			this.prioridade = prioridade;
			this.deadline = deadline;		
	}
		
	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public ResponsavelAtividade getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(ResponsavelAtividade responsavel) {
		this.responsavel = responsavel;
	}
	
	public SituacaoAtividade getSituaçao() {
		return situacao;		
	}
	
	public void setSituacao(SituacaoAtividade situacao) {
		this.situacao = situacao;
	}
	
	public PrioridadeAtividade getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(PrioridadeAtividade prioridade) {
		this.prioridade = prioridade;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgAtividade other = (AgAtividade) obj;
		return Objects.equals(numero, other.numero);			
	}
	
	@Override
	public String toString() {
		return "AgAtividade [numero= " + numero + "]";
		
	}	
}
