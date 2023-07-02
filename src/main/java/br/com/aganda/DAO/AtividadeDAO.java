package br.com.aganda.DAO;

import br.com.aganda.model.AgAtividade;
import br.com.aganda.model.PrioridadeAtividade;
import br.com.aganda.model.ResponsavelAtividade;
import br.com.aganda.model.SituacaoAtividade;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class AtividadeDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public AtividadeDAO() {
		em = EMFCreator.getEntityManager();
	}
	
	public void cadastrarAtividade(AgAtividade atividade) throws Exception{
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		
		try {			
			em.persist(atividade);
			em.getTransaction().commit();
			System.out.println("Cadastrada com sucesso");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Falha no cadastro");
			throw e;
		}
	}
	
	public List<AgAtividade> listarAgAtividade(String titulo, Long numero, String descricao, 
			ResponsavelAtividade responsavel, SituacaoAtividade situacao, PrioridadeAtividade prioridade, Date deadline) {
		StringBuilder jpql = new StringBuilder("Select t FROM AgAtividade t WHERE 1=1 ");
		Map<String, Object> parameters = new HashMap<>();
		
		if (titulo != null && !titulo.isEmpty()) {
			jpql.append("AND (t.titulo LIKE :titulo OR t.descricao LIKE :titulo) ");
			parameters.put("titulo", "%" + titulo + "%");
		}
		
		if (numero != null) {
			jpql.append("AND t.numero = :numero ");
			parameters.put("numero", numero);
		}
		
		if (descricao != null && !descricao.isEmpty()) {
			jpql.append("AND t.descricao LIKE :descricao ");
			parameters.put("descricao", "%" + descricao + "%");
		}
		
		if (responsavel != null) {
			jpql.append("AND t.responsavel = :responsavel ");
			parameters.put("responsavel", responsavel);
		}
		
		if (situacao != null) {
			jpql.append("AND t.situacao = :situacao ");
			parameters.put("situacao", situacao);
		}
		
		// Verifica se há algum critério de busca especificado
		if (parameters.isEmpty()) {
			return Collections.emptyList(); // Retorna uma lista vazia
		}
		
		TypedQuery<AgAtividade> query = em.createQuery(jpql.toString(), AgAtividade.class);
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}
	
	public void atualizarAtividade(AgAtividade atividade) throws Exception {
		em.getTransaction().begin();
		
		try {
			em.merge(atividade);
			em.getTransaction().commit();
	}catch (Exception e) {
		em.getTransaction().rollback();
		throw e;
		}
	}
	
	public void excluirAtividade(AgAtividade atividade) throws Exception {
		em.getTransaction().begin();
		
		try {
			atividade = em.find(AgAtividade.class, atividade.getNumero());
			em.remove(atividade);
			em.getTransaction().commit();
			System.out.println("excluido com sucesso!");
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw e;			
		}
	}
}
