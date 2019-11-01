package br.com.etec.acapi.teste;

import javax.swing.JOptionPane;

import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TestePesquisa {
 public static void main(String[] args) {
	 
	 BancoDAO dao = new BancoDAO();
		 
	 int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto"));
	
	 Produto produto = new Produto();
	 produto = dao.buscarProdutoPorId(id);
	 
	 JOptionPane.showMessageDialog(null, "O nome : " + produto.getNome()+"\n"+
	 "A descrição : " + produto.getDescricao() + "\n" +
			 "O preço : " + produto.getPreco() + 
			 "\n" + "O fornecedor : "+ produto.getFornecedor().getNome());
	 }
}
