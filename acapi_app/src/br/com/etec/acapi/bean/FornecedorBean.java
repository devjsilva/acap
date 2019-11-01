package br.com.etec.acapi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;

@ManagedBean
@ViewScoped
public class FornecedorBean {

	private Fornecedor fornecedor = new Fornecedor();
	private List<Fornecedor> fornecedores;
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		BancoDAO dao = new BancoDAO();
	    fornecedores =    dao.buscaListaFornecedor();
				
		if(this.fornecedores == null){
	   		this.fornecedores =   dao.buscaListaFornecedor();
	   		
	   	}
		return fornecedores;
		
    }
	
	public void remover(Fornecedor fornecedor){
		System.out.println("Removendo o produto" + fornecedor.getNome() + " id: " + fornecedor.getId());
		BancoDAO dao = new BancoDAO();
		dao.removerFornecedor(fornecedor.getId());
		this.fornecedores =   dao.buscaListaFornecedor();
	}
	
	public void carrega(Fornecedor fornecedor){
		System.out.println("Carregando o produto" + fornecedor.getNome() + " id: " + fornecedor.getId());
		this.fornecedor = fornecedor;
		
	}


	public void gravar() {

		System.out.println("Gravando o produto " + this.fornecedor.getNome());
		BancoDAO dao = new BancoDAO();
		dao.salvarFornecedor(fornecedor);
		
		this.fornecedor = new Fornecedor();
		this.fornecedores =   dao.buscaListaFornecedor();

	}

	
}
