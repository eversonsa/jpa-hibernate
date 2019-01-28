package br.com.alura.teste;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Conta;
import br.com.alura.util.JPAUtil;

public class EstadoDetached {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta1 = new Conta();
		conta1.setBanco("001 - BANCO DO BRASIL");
		conta1.setNumero("16987-8");
		conta1.setAgencia("6543");
		conta1.setTitular("Morrisey everson");
		
		em.getTransaction().begin();
		em.persist(conta1);
		
		System.out.println(conta1.getTitular());
		
		em.getTransaction().commit();
		em.close();
////////////////////////////////////////////	
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		conta1.setTitular("paulo");
		// com erro de detached
        //em2.persist(conta1);
		
		em2.merge(conta1);
		
		System.out.println(conta1.getTitular());
		
		em2.getTransaction().commit();
		em2.close();
	}
}
