package br.com.etec.acapi.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.validator.ValidatorException;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.Compra;
import br.com.etec.acapi.modelo.Produto;
import br.com.etec.acapi.modeloDAO.BancoDAO;
import br.com.etec.acapi.util.Mensagem;

@ManagedBean
@ViewScoped
public class CaixaBean {

	private Compra compra = new Compra();
	private List<Produto> produtos = new ArrayList<Produto>();
	private Produto produto = new Produto();
	private Carrinho carrinho = new Carrinho();
	private Integer idProduto;
	private Integer idCarrinho;
	private double preçoFinal = 0.0;
	private int quantidade;

	public Integer getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Integer idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreçoFinal() {
		return preçoFinal;
	}

	public void setPreçoFinal(double preçoFinal) {
		this.preçoFinal = preçoFinal;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer id) {
		this.idProduto = id;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public Compra getCompra() {
		return compra;
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void gravar() {
		BancoDAO dao = new BancoDAO();
		produto = dao.buscarProdutoPorId(idProduto);
		System.out.println("Gravando" + produto.getNome() + " id: " + produto.getId());
		double resultadoPreco = quantidade * produto.getPreco();
		preçoFinal += resultadoPreco;
		// int resultado = produto.getQtd() - quantidade;

		for (int x = 0; x < quantidade; x++) {
			produtos.add(produto);
		}

		// produto.setQtd(quantidade);

	}

	public void gravarCarrinho() {
		BancoDAO dao = new BancoDAO();
		List<Produto> lista;
		Carrinho carrinho = new Carrinho();
		carrinho = dao.buscarCarrinhoPorId(idCarrinho);
		lista = carrinho.getProdutos();

		System.out.println("Gravando" + " id: " + carrinho.getId());

		for (Produto produto : lista) {
			System.out.println("Produto" + " nome: " + produto.getNome());
			preçoFinal += produto.getPreco();
			produtos.add(produto);
		}

	}

	public void remover(Produto produto) {
		System.out.println("Removendo o produto" + produto.getNome() + " id: " + produto.getId());
		int posicao = 0;
		for (Produto produtoLista : produtos) {
			if (produtoLista.getId() == produto.getId()) {
				preçoFinal = preçoFinal - produto.getPreco();
				produtos.remove(posicao);
				break;
			}
			posicao++;
		}
		Mensagem mensagem = new Mensagem();

		mensagem.exibirMensagem("Remoção feita com sucesso!", "O produto " + produto.getNome() + " foi removido!");

	}

	public void finalizarCompra() {
		BancoDAO dao = new BancoDAO();

		carrinho = dao.buscarCarrinhoPorId(getIdCarrinho());
		compra.setCarrinho(carrinho);
		compra.setProdutos(produtos);
		compra.setValorDaCompra(preçoFinal);
		compra.setFinalizada(true);
		dao.salvarCompra(compra);

		List<Produto> lista = new ArrayList<Produto>();
		lista = dao.buscaListaProdutos();

		for (Produto produtoLista : lista) {
			for (Produto produto : produtos) {
				if (produto.getId() == produtoLista.getId()) {
					produto.setQtd(produto.getQtd() - 1);
				}
			}
		}
		dao.salvarProduto(produto);

		compra = new Compra();
		preçoFinal = 0;
		produtos = new ArrayList<Produto>();
		idCarrinho = 0;
		idProduto = 0;
		quantidade = 0;
		System.out.println("Salvando a compra!!!");
	}

	public void adicionar() {

		List<String> numeros = new ArrayList<String>();
		List<Integer> ids = new ArrayList<Integer>();
		produtos = new ArrayList<Produto>();
		preçoFinal = 0.0;
		BancoDAO dao = new BancoDAO();

		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader("C:/Users/manager/Desktop/teste/produtos.txt"))
					.useDelimiter(",||,n");
			while (scanner.hasNext()) {
				String nome = scanner.next();
				System.out.println(nome);
				numeros.add(nome);

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("Opa irmão deu ruim!!!!");
			System.out.println("Arquivo não encontrado!!!!");
			Mensagem mensagem = new Mensagem();
			mensagem.exibirMensagem("Opa!!!! muita calma ai, coloque um carrinho no sensor", "Cade o carrinho????????");
		}

		for (String numero : numeros) {
			int id = Integer.parseInt(numero);
			ids.add(id);
		}

		System.out.println(ids);

		for (int id : ids) {
			Produto produto = dao.buscarProdutoPorId(id);
			preçoFinal += produto.getPreco();
			produtos.add(produto);
		}

		for (Produto produto : produtos) {
			System.out.println(produto.getNome());
		}
		

		File file = new File("C:/Users/manager/Desktop/teste/produtos.txt");
		boolean resultado = file.delete();

		if (resultado) {
			System.out.println("Aquivo excluido");
		}

	}
}
