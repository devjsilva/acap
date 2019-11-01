package br.com.etec.acapi.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("acapi");
	
	public EntityManager getConexao() {
		
		return emf.createEntityManager();
	}
}

