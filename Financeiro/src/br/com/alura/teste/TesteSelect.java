package br.com.alura.teste;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Conta;
import br.com.alura.util.JPAUtil;

public class TesteSelect {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();	
		Conta conta = manager.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		manager.getTransaction().commit();
		manager.close();
	}
}
