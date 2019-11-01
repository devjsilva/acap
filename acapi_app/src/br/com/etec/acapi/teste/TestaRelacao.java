package br.com.etec.acapi.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.Categoria;
import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TestaRelacao {
	
	public static void main(String[] args) {
		BancoDAO dao = new BancoDAO();
		Carrinho carrinho1 = new Carrinho();
		carrinho1.setNumeroDeRegistro(2134);
		
		Fornecedor fornecedor1 = new Fornecedor();
		fornecedor1.setCNPJ("122344");
		fornecedor1.setDescricao("loja de produtos maduros");
		fornecedor1.setNome("loja tropical");
		
		
		Produto produto1 = new Produto();
		produto1.setNome("abacate");
		produto1.setDescricao("Fruta verde");
		produto1.setPreco(6.00);
	//	produto1.setTipo(Categoria.FRUTA);
		produto1.setFornecedor(fornecedor1);
		
		Produto produto2 = new Produto();
		produto2.setNome("abacaxi");
		produto2.setDescricao("Fruta tropical");
		produto2.setPreco(16.00);
		//produto2.setTipo(Categoria.FRUTA);
		produto2.setFornecedor(fornecedor1);
		
		Produto produto3 = new Produto();
		produto3.setNome("coco");
		produto3.setDescricao("validade - 02/03/19");
		produto3.setPreco(12.00);
		//produto3.setTipo(Categoria.FRUTA);
		produto3.setFornecedor(fornecedor1);
		
	    List<Produto> listaDeCompras = new ArrayList();
	    
	    listaDeCompras.add(produto1);
	    listaDeCompras.add(produto2);
	    listaDeCompras.add(produto3);
	    
	    carrinho1.setProdutos(listaDeCompras);
	    
	    dao.salvarFornecedor(fornecedor1);
	    dao.salvarProduto(produto1);
	    dao.salvarProduto(produto2);
	    dao.salvarProduto(produto3);
	    dao.salvarCarrinho(carrinho1);
	    
	    
		
	}
	
}
