package br.com.etec.acapi.teste;

import javax.swing.JOptionPane;

import br.com.etec.acapi.modelo.Funcionario;
import br.com.etec.acapi.modeloDAO.BancoDAO;

public class TestePrototipo {
public static void main(String[] args) {
	System.out.println("iniciar Teste");
	
	BancoDAO dao = new BancoDAO();
	 
	JOptionPane.showMessageDialog(null, "ACAPI");
	
	 int resp1 = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo \n\n Qual dessas opções vc se enquadra:"+
	  "1-Cliente \n 2-Funcionario"));
	 
	 if(resp1 == 1) {
		 JOptionPane.showMessageDialog(null, "EM manutenção !!!!!!!!");
		 
	 }if(resp1 == 2) {
		 int idFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Funcionario \n\n coloque o numero de indentificação"));
		Funcionario Funcionario = new Funcionario();
		Funcionario = dao.buscarFuncionarioPorId(idFuncionario);
		 String senha = JOptionPane.showInputDialog("Funcionario \n\n coloque a senha");
		 if(senha == Funcionario.getSenha()) {
			 int resp2 = Integer.parseInt(JOptionPane.showInputDialog("QUAL DAS OPÇÕES \n\n"+
		 "1-Produtos \n 2-Fornecedores \n 3-Carrinhos \n 4-Funcionarios"));
			 if(resp2 == 1) {
				 
			 }			 
			 
		 }else {
			 JOptionPane.showInputDialog("Acesso negado!!!!");
		 }
	 }
	 
	 
	 
	 
	
}
}
