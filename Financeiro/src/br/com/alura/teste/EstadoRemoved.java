package br.com.alura.teste;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Conta;
import br.com.alura.util.JPAUtil;

public class EstadoRemoved {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta conta = new Conta();
		conta = em.find(Conta.class, 9);
		em.remove(conta);
		em.getTransaction().commit();
		System.out.println("conta removida com sucesso");
		em.close();
	}
}
