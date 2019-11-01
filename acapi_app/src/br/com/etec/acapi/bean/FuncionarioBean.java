package br.com.etec.acapi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Funcionario;
import br.com.etec.acapi.modeloDAO.BancoDAO;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios;

	public Funcionario getFuncionario() {
		return funcionario;
	}
	

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public List<Funcionario> getFuncionarios() {
		BancoDAO dao = new BancoDAO();
	    funcionarios =  dao.buscaListaFuncionarios();
		
		if(this.funcionarios == null){
	   		this.funcionarios =   dao.buscaListaFuncionarios();
	   		
	   	}
		return funcionarios;
	 }
	
	public void remover(Funcionario funcionario){
		System.out.println("Removendo o produto" + funcionario.getNome() + " id: " + funcionario.getId());
		BancoDAO dao = new BancoDAO();
		dao.removerFuncionario(funcionario.getId());
		this.funcionarios =   dao.buscaListaFuncionarios();
	}
	
	public void carrega(Funcionario funcionario){
		System.out.println("Carregando o produto" + funcionario.getNome() + " id: " + funcionario.getId());
		this.funcionario = funcionario;
	}


	public void gravar() {

		System.out.println("Gravando o produto " + this.funcionario.getNome());
		BancoDAO dao = new BancoDAO();
		dao.salvarFuncionario(funcionario);
		
		this.funcionario = new Funcionario();
		this.funcionarios =   dao.buscaListaFuncionarios();

	}
}
