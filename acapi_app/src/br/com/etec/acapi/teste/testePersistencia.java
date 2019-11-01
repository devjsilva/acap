package br.com.etec.acapi.teste;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class testePersistencia {

	public static void main(String[] args) {
		BancoDAO dao = new BancoDAO();
		
		
		
		Carrinho carrinho1 = new Carrinho();
		carrinho1.setNumeroDeRegistro(12345);
		
		dao.salvarCarrinho(carrinho1);
	}
	
}
