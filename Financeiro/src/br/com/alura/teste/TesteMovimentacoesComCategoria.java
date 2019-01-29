package br.com.alura.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Conta;
import br.com.alura.modelo.Movimentacao;
import br.com.alura.modelo.TipoMovimentacao;
import br.com.alura.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("viagem");
		Categoria categoria2 = new Categoria("alimentacao");
		
		Conta conta = new Conta();
		conta.setId(11);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("viajem ao RJ");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("350"));
		movimentacao.setConta(conta);
		movimentacao.setCategoria(Arrays.asList(categoria1, categoria2));
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("viajem ao RJ");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("350"));
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao1);
		
		em.getTransaction().commit();
		em.close();		
		
	}
}
