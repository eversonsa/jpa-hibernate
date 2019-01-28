package br.com.alura.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.modelo.Conta;
import br.com.alura.util.JPAUtil;

public class TestaConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("6614");
		conta.setBanco("caixa");
		conta.setNumero("1425");
		conta.setTitular("everson");
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		
		
	}
}
