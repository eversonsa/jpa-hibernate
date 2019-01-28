package br.com.alura.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.Movimentacao;
import br.com.alura.modelo.TipoMovimentacao;
import br.com.alura.util.JPAUtil;

public class TesteMapeamentoManiToOne {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta conta = new Conta();
		conta.setAgencia("0501-5");
		conta.setBanco("JP Morgan");
		conta.setNumero("04056");
		conta.setTitular("Dr. Paulo");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("200.0"));
		movimentacao.setConta(conta);
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}

}
