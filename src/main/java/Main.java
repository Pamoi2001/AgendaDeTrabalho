
import br.com.aganda.model.AgAtividade;
import br.com.aganda.model.PrioridadeAtividade;
import br.com.aganda.model.SituacaoAtividade;
import br.com.aganda.model.ResponsavelAtividade;

import java.util.Date;

import br.com.aganda.DAO.AtividadeDAO; 

public class Main {	
	
	public static void main(String[] args) throws Exception{
		
		
		AtividadeDAO cad = new AtividadeDAO();
		AgAtividade aga = new AgAtividade();
		Date deadline = new Date(23/04/2023);
		
		aga.setTitulo("Jojo");
		aga.setDescricao(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");
		aga.setResponsavel(ResponsavelAtividade.Moi);
		aga.setPrioridade(PrioridadeAtividade.Media);
		aga.setSituacao(SituacaoAtividade.Em_Andamento);
		aga.setDeadline(deadline);
		
		cad.cadastrarAtividade(aga);
		

		
	}

}
