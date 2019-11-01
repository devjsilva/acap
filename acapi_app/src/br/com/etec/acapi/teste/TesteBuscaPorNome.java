package br.com.etec.acapi.teste;

import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TesteBuscaPorNome {
	public static void main(String[] args) {
		BancoDAO dao = new BancoDAO();
		Produto produto = new Produto();
		
		produto = dao.buscaProdutoPorNome("feijao");
		
		System.out.println(produto.getId());
		
	}
}
