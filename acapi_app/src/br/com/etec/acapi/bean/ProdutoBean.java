package br.com.etec.acapi.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.CategoriasProdutos;
import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Funcionario;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;
import br.com.etec.acapi.util.Mensagem;
import br.com.etec.acapi.util.RedirectView;

@ManagedBean
@ViewScoped
public class ProdutoBean {


	private Produto produto = new Produto();
	private Integer idFornecedor;
	private Integer idCategoria;
	private List<Produto> produtos;
	
	
	public Produto getProduto() {
		return produto;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	
	
	public List<Fornecedor> getFornecedores() {
		BancoDAO dao = new BancoDAO();
		List<Fornecedor> fornecedores =    dao.buscaListaFornecedor();
		
		return fornecedores;
    }
	
	
	public List<CategoriasProdutos> getCategorias() {
		BancoDAO dao = new BancoDAO();
		List<CategoriasProdutos> categorias =   dao.buscaListaCategorias();
		
		return categorias;
    }
	
	public void gravarFornecedor(){
		
		Fornecedor fornecedor =new BancoDAO().buscarFornecedorPorId(idFornecedor);
		this.produto.setFornecedor(fornecedor);	
		
	}
	

	public void gravarCategoria(){
		
		CategoriasProdutos categoria =new BancoDAO().buscarCategorisPorId(idCategoria);
		this.produto.setTipo(categoria);
		
	}
	
	public void remover(Produto produto){
		System.out.println("Removendo o produto" + produto.getNome() + " id: " + produto.getId());
		BancoDAO dao = new BancoDAO();
		dao.removerProduto(produto.getId());
		Mensagem mensagem = new Mensagem();
		mensagem.exibirMensagem("Remoção feita com sucesso!", "O produto " + produto.getNome() + " foi removido!");				
		this.produtos = dao.buscaListaProdutos();
	}
	
	public void carrega(Produto produto){
		System.out.println("Carregando o produto" + produto.getNome() + " id: " + produto.getId());
		this.produto = produto;
	}
	
	public RedirectView formFornecedor(){
		System.out.println("Indo para o formulario fornecedor");
		return new RedirectView("fornecedor");
	}

	public void gravar() {

		System.out.println("Gravando o produto " + this.produto.getNome());
		gravarCategoria();
		gravarFornecedor();		
		BancoDAO dao = new BancoDAO();
		dao.salvarProduto(produto);
		
		Mensagem mensagem = new Mensagem();
		mensagem.exibirMensagem("Cadastrado com sucesso!","O produto " + produto.getNome() + " foi cadastrado");
		this.produto = new Produto();
		this.produtos = dao.buscaListaProdutos();
		//addMessage("Gravado com sucesso!!!!");
		
	}
	
	public List<Produto> getProdutos() {
		BancoDAO dao = new BancoDAO();
	   	
		
	   	if(this.produtos == null){
	   		this.produtos =   dao.buscaListaProdutos();
	   		
	   	}
	   	
		return produtos;
    }
	
	public void validaPreco(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

	    String valor = value.toString();
	    Double valorFinal = Double.valueOf(valor);
	    if (valorFinal == 0.0) {
	        throw new ValidatorException(new FacesMessage("O preço do produto não pode começar ser 0.0"));
	    }
	}
	public void validaQtd(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

	    String valor = value.toString();
	    Integer valorFinal =Integer.valueOf(valor);
	    if (valorFinal == 0.0) {
	        throw new ValidatorException(new FacesMessage("A quantidade não pode ser 0"));
	    }
	}

	

}
