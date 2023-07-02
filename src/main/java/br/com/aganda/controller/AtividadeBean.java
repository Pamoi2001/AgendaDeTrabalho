package br.com.aganda.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aganda.DAO.AtividadeDAO;
import br.com.aganda.model.AgAtividade;
import br.com.aganda.model.PrioridadeAtividade;
import br.com.aganda.model.ResponsavelAtividade;
import br.com.aganda.model.SituacaoAtividade;


@Named
@ViewScoped
public class AtividadeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long numero;
	private String titulo;
	private String descricao;
	private ResponsavelAtividade responsavel;
	private PrioridadeAtividade prioridade;
	private SituacaoAtividade situacao;
	private Date deadline;
	
	@Inject
	private AtividadeDAO atividadeDAO;
	
	@Inject
	private AgAtividade atividade;
	
	private List<AgAtividade> atividades;
	
	public AtividadeBean() {
	}
	
	public AgAtividade getAgAtividade() {
		return atividade;
	}
	
	public void setAgAtividade(AgAtividade atividade) {
		this.atividade = atividade;
	}
	
	public List<AgAtividade> getAgAtividades() {
		return atividades;
	}
	
	public void setAgAtividades(List<AgAtividade> atividades) {
		this.atividades = atividades;
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
		this.titulo = titulo.strip();
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao.strip();
	}
	
	public ResponsavelAtividade[] getResponsaveis() {
		return ResponsavelAtividade.values();
	}
	
	public ResponsavelAtividade getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(ResponsavelAtividade responsavel) {
		this.responsavel = responsavel;
	}
	
	public PrioridadeAtividade[] getPrioridades() {
		return PrioridadeAtividade.values();
	} 
	
	public PrioridadeAtividade getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(PrioridadeAtividade prioridade) {
		this.prioridade = prioridade;
	}
	
	public SituacaoAtividade[] getSituacoes() {
		return SituacaoAtividade.values();
	}
	
	public SituacaoAtividade getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoAtividade situacao) {
		this.situacao = situacao;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public void cadastrarAgAtividade() throws Exception {
		setSituacao(SituacaoAtividade.Em_Andamento);
		AgAtividade atividade = new AgAtividade(titulo, descricao, responsavel, situacao, prioridade, deadline);
		atividadeDAO.cadastrarAtividade(atividade);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso :", "As informações foram cadastradas com sucesso"));
		limparCampos();
	}
	
	public void listarAgAtividades() {
		try {
			atividades = atividadeDAO.listarAgAtividade(titulo, numero, descricao, responsavel, situacao, prioridade, deadline);
		}catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao listar", "Ocorreu um erro ao listar as informações."));			
		}
	}
	
	public void abrirDialogEditarAgAtividade(AgAtividade atividade) {
		this.atividade.setNumero(atividade.getNumero());
		this.atividade.setTitulo(atividade.getTitulo());
		this.atividade.setDescricao(atividade.getDescricao());
		this.atividade.setResponsavel(atividade.getResponsavel());
		this.atividade.setPrioridade(atividade.getPrioridade());
		this.atividade.setSituacao(atividade.getSituaçao());
		this.atividade.setDeadline(atividade.getDeadline());
	}
	
	public void salvarEdicaoAgAtividade() throws Exception{
		atividadeDAO.atualizarAtividade(atividade);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso :", "Foi Editado com sucesso"));
		listarAgAtividades();
	}
	
	public void excluirAgAtividade(AgAtividade atividade) throws Exception{
		atividadeDAO.excluirAtividade(atividade);
		listarAgAtividades();
		limparCampos();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso :", "Foi Excluido com sucesso"));		
	}
	
	public void concluirAgAtividade(AgAtividade atividade) throws Exception {
		atividade.setSituacao(SituacaoAtividade.Concluido);
		atividadeDAO.atualizarAtividade(atividade);
		listarAgAtividades();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso :", "Concluído com sucesso"));
	}
	
	public void limparCampos() {
		titulo = null;
		descricao = null;
		responsavel = null;
		prioridade = null;
		deadline = null;
	}
}