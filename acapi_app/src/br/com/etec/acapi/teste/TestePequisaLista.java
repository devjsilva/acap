package br.com.etec.acapi.teste;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TestePequisaLista {
public static void main(String[] args) {
	BancoDAO dao = new BancoDAO();

	 JOptionPane.showInputDialog("Lista de produtos cadastrados");
	 
	 List<Produto> produtos = dao.buscaListaProdutos();
	 
	 for (Produto produto : produtos) {
		 
		 JOptionPane.showMessageDialog(null, "Nome : " + produto.getNome()+ "\n"+
					"Descrição : " + produto.getDescricao() + "\n"+
						"Preço : " + produto.getPreco() + "\n" + 
					"Tipo : " + produto.getTipo() + "\n" + 
						"Fornecedor : " + produto.getFornecedor().getNome());
		
	}
}
}
