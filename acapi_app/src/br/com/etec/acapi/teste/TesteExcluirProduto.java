package br.com.etec.acapi.teste;

import javax.swing.JOptionPane;

import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TesteExcluirProduto {
public static void main(String[] args) {
	BancoDAO dao = new BancoDAO();

	 int id = Integer.parseInt(JOptionPane.showInputDialog("Remover produto \n\n Coloque o id do produto"));
	 dao.removerProduto(id);
}
}
