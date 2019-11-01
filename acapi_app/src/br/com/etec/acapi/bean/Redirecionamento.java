package br.com.etec.acapi.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.etec.acapi.util.RedirectView;

@ManagedBean
@ViewScoped
public class Redirecionamento {

	public RedirectView mudaFormProduto(){
		System.out.println("Indo para a pagina protudo");
		return new RedirectView("produto");
		}
	public RedirectView mudaFormFornecedor(){
		System.out.println("Indo para a pagina fornecedor");
		return new RedirectView("fornecedor");
		}
	public RedirectView mudaFormFuncionario(){
		System.out.println("Indo para a pagina funcionario");
		return new RedirectView("funcionario");
		}
	public RedirectView mudaFormCarrinho(){
		System.out.println("Indo para a pagina carrinho");
		return new RedirectView("carrinho");
		}
	public RedirectView mudaFormBemVindo(){
		System.out.println("Indo para a pagina carrinho");
		return new RedirectView("bemVindo");
		}
	public RedirectView mudaFormCaixa(){
		System.out.println("Indo para a pagina carrinho");
		return new RedirectView("caixa");
		}
	
	
	
	
	
	//public RedirectView mudaForm(String local){
	//	System.out.println("Indo para a pagina" + local);
	//	return new RedirectView(local);
	
}
