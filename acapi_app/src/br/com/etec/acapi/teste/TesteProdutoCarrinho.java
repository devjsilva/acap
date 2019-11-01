package br.com.etec.acapi.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TesteProdutoCarrinho {
public static void main(String[] args) {
     List<Produto> produtos = new ArrayList<Produto>();
     Integer id =1;
     
     
	BancoDAO dao = new BancoDAO();
	List<Produto> lista;
	Carrinho carrinho = new Carrinho();
	carrinho = dao.buscarCarrinhoPorId(id);
	lista =  carrinho.getProdutos();
	
	
	System.out.println("Gravando"  + " id: " + carrinho.getId());
	for (Produto produto : lista) {
    	System.out.println("Produto"  + " nome: " + produto.getNome());
		produtos.add(produto);
	}		
   
}
}
