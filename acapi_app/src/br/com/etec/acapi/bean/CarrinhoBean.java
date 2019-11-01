package br.com.etec.acapi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modeloDAO.BancoDAO;

@ManagedBean
@ViewScoped
public class CarrinhoBean {

	private Carrinho carrinho = new Carrinho();
	private List<Carrinho> carrinhos;

	public Carrinho getCarrinho() {
		return carrinho;
	}
	
	public List<Carrinho> getCarrinhos() {
		BancoDAO dao = new BancoDAO();
		List<Carrinho> carrinhos = dao.buscaListaCarrinho();
		
		if(this.carrinhos == null){
	   		this.carrinhos =   dao.buscaListaCarrinho();
	   		
	   	}
		return carrinhos;
   }
	
	public void remover(Carrinho carrinho){
		System.out.println("Removendo o produto" + carrinho.getNumeroDeRegistro() + " id: " + carrinho.getId());
		BancoDAO dao = new BancoDAO();
		dao.removerCarrinho(carrinho.getId());
		this.carrinhos =   dao.buscaListaCarrinho();
	}
	
	public void carrega(Carrinho carrinho){
		System.out.println("Carregando o produto" + carrinho.getNumeroDeRegistro() + " id: " + carrinho.getId());
		this.carrinho = carrinho;
		
	}


	public void gravar() {

		System.out.println("Gravando o produto " + this.carrinho.getId());
		BancoDAO dao = new BancoDAO();
		dao.salvarCarrinho(carrinho);
		
		this.carrinho = new Carrinho();
		this.carrinhos =   dao.buscaListaCarrinho();

	}
}
