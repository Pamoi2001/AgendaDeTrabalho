package br.com.aganda.model;

public enum PrioridadeAtividade {
	Baixa("Baixa"),
	Media("Média"),
	Alta("Alta");
	
	private String prioridade;
	
	PrioridadeAtividade(String prioridade){
		this.prioridade = prioridade;
	}
	
	public String getPrioridade() {
		return prioridade;
	}

}
