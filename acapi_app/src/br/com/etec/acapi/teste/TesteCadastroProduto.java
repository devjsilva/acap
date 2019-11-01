package br.com.etec.acapi.teste;

import javax.swing.JOptionPane;

import br.com.etec.acapi.modelo.Categoria;
import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TesteCadastroProduto {
public static void main(String[] args) {
	BancoDAO dao = new BancoDAO();
	JOptionPane.showMessageDialog(null, "ACAPI");
	
	 String nome = JOptionPane.showInputDialog("Cadastro de Produtos \n\n coloque o nome do produto");
	 Produto produto = new Produto();
	 produto.setNome(nome);
	 
	 String descricao = JOptionPane.showInputDialog("Cadastro de Produtos \n coloque a descricao");
	 produto.setDescricao(descricao);
	 
	 int tipo = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Produtos \n\n coloque o tipo \n"+
	 "1-Comida, 2-Bebida, 3-Remedio, 4-Acessorio"));
	 if(tipo == 1) {
		// produto.setTipo(Categoria.COMIDA);
		 }if(tipo == 2) {
			// produto.setTipo(Categoria.BEBIDA);
			 }if(tipo == 3) {
				// produto.setTipo(Categoria.REMEDIO);
				 }if(tipo == 4) {
					// produto.setTipo(Categoria.ACESSORIO);
				 }
		
	 double preco = Double.parseDouble(JOptionPane.showInputDialog("Cadastro de Produtos \n\n Coloque o preço do produto"));		 
		produto.setPreco(preco);
		
		
		 int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Produtos \n\n coloque o id do fornecedor"));	
	
		 Fornecedor fornecedor = dao.buscarFornecedorPorId(idFornecedor);
		 produto.setFornecedor(fornecedor);	
		 
		 dao.salvarProduto(produto);
				 
}
}
