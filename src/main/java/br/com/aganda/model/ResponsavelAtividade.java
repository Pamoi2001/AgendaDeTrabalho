package br.com.aganda.model;

public enum ResponsavelAtividade {
	Moi("Moisés Ramos dos Santos"),
	Dane("Daniel Alcantara"),
	Rafa("Rafael Mascareias"),
	Marun("Roberto Marun");
	
	private String responsavel;
	
	ResponsavelAtividade(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public String getResponsavel() {
		return responsavel;
	}

}
