package br.com.etec.acapi.util;

import java.util.ArrayList;
import java.util.List;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class EntradaCarrinho {
public static void main(String[] args) {
BancoDAO dao = new BancoDAO();
	
	
	
	Carrinho carrinho = new Carrinho();
	carrinho.setId(id(1));
	carrinho.setProdutos(produtos());
}

public static List<Produto> produtos(){
	List<Produto> produtos = new ArrayList<Produto>();
	
	return produtos;
	
}
public static Integer id(Integer id){
	
	return id;
	
}


}
