package br.com.aganda.model;

public enum SituacaoAtividade {
	Em_Andamento("Em andamento"),
	Concluido("Concluído");
	
	private String situacao;
	
	SituacaoAtividade(String situacao){
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}

}
