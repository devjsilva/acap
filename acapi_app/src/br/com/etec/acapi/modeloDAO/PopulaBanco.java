package br.com.etec.acapi.modeloDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.etec.acapi.modelo.Carrinho;
import br.com.etec.acapi.modelo.CategoriasProdutos;
import br.com.etec.acapi.modelo.Fornecedor;
import br.com.etec.acapi.modelo.Funcionario;
import br.com.etec.acapi.modelo.Produto;

public class PopulaBanco {
	public static void main(String[] args) {

		BancoDAO dao = new BancoDAO();

		Fornecedor fornecedor1 = new Fornecedor();
		fornecedor1.setNome("Feira das frutas");
		fornecedor1.setCNPJ("12222222222222");
		fornecedor1.setDescricao("Loja de produção agricula");

		Fornecedor fornecedor2 = new Fornecedor();
		fornecedor2.setNome("Tropical Nacional");
		fornecedor2.setCNPJ("13333333323333");
		fornecedor2.setDescricao("Loja de bebidas");

		Fornecedor fornecedor3 = new Fornecedor();
		fornecedor3.setNome("O fortuna");
		fornecedor3.setCNPJ("12345677722222");
		fornecedor3.setDescricao("Loja de cereais");

		Fornecedor fornecedor4 = new Fornecedor();
		fornecedor4.setNome("Teste dia");
		fornecedor4.setCNPJ("1111111112111");
		fornecedor4.setDescricao("Loja de testes");

		CategoriasProdutos tipo1 = new CategoriasProdutos();
		tipo1.setTipo("FRUTA");

		CategoriasProdutos tipo2 = new CategoriasProdutos();
		tipo2.setTipo("LEGUME");

		CategoriasProdutos tipo3 = new CategoriasProdutos();
		tipo3.setTipo("FRIOS");

		CategoriasProdutos tipo4 = new CategoriasProdutos();
		tipo4.setTipo("DOCES");

		CategoriasProdutos tipo5 = new CategoriasProdutos();
		tipo5.setTipo("REMEDIO");

		CategoriasProdutos tipo6 = new CategoriasProdutos();
		tipo6.setTipo("ACESSORIO");

		CategoriasProdutos tipo7 = new CategoriasProdutos();
		tipo7.setTipo("ROUPA");

		CategoriasProdutos tipo8 = new CategoriasProdutos();
		tipo8.setTipo("BEBIDA");

		CategoriasProdutos tipo9 = new CategoriasProdutos();
		tipo9.setTipo("COMIDA");

		Produto produto1 = new Produto();
		produto1.setDescricao("Bananas verdes");
		produto1.setNome("Banana");
		produto1.setTipo(tipo1);
		produto1.setPreco(2.00);
		produto1.setQtd(50);
		produto1.setDataValidade(parseData("20/09/2019"));
		produto1.setFornecedor(fornecedor1);

		Produto produto2 = new Produto();
		produto2.setDescricao("suco com sabor laranja");
		produto2.setNome("Suco");
		produto2.setTipo(tipo8);
		produto2.setPreco(6.00);
		produto2.setQtd(100);
		produto2.setDataValidade(parseData("31/05/2020"));
		produto2.setFornecedor(fornecedor2);

		Produto produto3 = new Produto();
		produto3.setDescricao("balas de sabor tutti frutti");
		produto3.setNome("Balas");
		produto3.setTipo(tipo4);
		produto3.setPreco(1.50);
		produto3.setQtd(200);
		produto3.setDataValidade(parseData("10/10/2019"));
		produto3.setFornecedor(fornecedor3);
		
		Produto produto4 = new Produto();
		produto4.setDescricao("caixa com 20 morangos");
		produto4.setNome("Morango");
		produto4.setTipo(tipo1);
		produto4.setPreco(4.00);
		produto4.setQtd(20);
		produto4.setDataValidade(parseData("10/10/2019"));
		produto4.setFornecedor(fornecedor3);
		
		Produto produto5 = new Produto();
		produto5.setDescricao("coca-cola com 2 Litros");
		produto5.setNome("coca-cola");
		produto5.setTipo(tipo2);
		produto5.setPreco(5.00);
		produto5.setQtd(30);
		produto5.setDataValidade(parseData("10/10/2019"));
		produto5.setFornecedor(fornecedor2);
		
		Produto produto6 = new Produto();
		produto6.setDescricao("salgado com 500 gramas");
		produto6.setNome("salgado");
		produto6.setTipo(tipo9);
		produto6.setPreco(2.00);
		produto6.setQtd(30);
		produto6.setDataValidade(parseData("10/10/2019"));
		produto6.setFornecedor(fornecedor1);
		
		Produto produto7 = new Produto();
		produto7.setDescricao("Milho com 250 gramas");
		produto7.setNome("milho");
		produto7.setTipo(tipo9);
		produto7.setPreco(7.00);
		produto7.setQtd(15);
		produto7.setDataValidade(parseData("10/10/2019"));
		produto7.setFornecedor(fornecedor2);

		Carrinho carrinho1 = new Carrinho();
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		carrinho1.setProdutos(produtos);
		carrinho1.setNumeroDeRegistro(12345);

		Carrinho carrinho2 = new Carrinho();
		List<Produto> produtos1 = new ArrayList<Produto>();
		
		produtos1.add(produto1);
		produtos1.add(produto1);
		produtos1.add(produto1);
		produtos1.add(produto2);
		produtos1.add(produto4);
		produtos1.add(produto5);
		produtos1.add(produto6);
		produtos1.add(produto7);
		
		carrinho2.setProdutos(produtos1);
		carrinho2.setNumeroDeRegistro(12344);

		Carrinho carrinho3 = new Carrinho();
		carrinho3.setNumeroDeRegistro(12335);

		Funcionario Funcionario1 = new Funcionario();
		Funcionario1.setNome("Roberto");
		Funcionario1.setCpf("12345678901");
		Funcionario1.setSenha("123");
		Funcionario1.setUsuario("roberto@gmail.com");

		Funcionario Funcionario2 = new Funcionario();
		Funcionario2.setNome("Matheus");
		Funcionario2.setCpf("12345678905");
		Funcionario2.setSenha("122");
		Funcionario2.setUsuario("matheus@gmail.com");
		
		Funcionario Funcionario3 = new Funcionario();
		Funcionario3.setNome("Gustavo");
		Funcionario3.setCpf("12345678904");
		Funcionario3.setSenha("133");
		Funcionario3.setUsuario("gustavo@gmail.com");
		
		dao.salvarFornecedor(fornecedor1);
		dao.salvarFornecedor(fornecedor2);
		dao.salvarFornecedor(fornecedor3);
		dao.salvarFornecedor(fornecedor4);
		
		dao.salvarCategoria(tipo1);
		dao.salvarCategoria(tipo2);
		dao.salvarCategoria(tipo3);
		dao.salvarCategoria(tipo4);
		dao.salvarCategoria(tipo5);
		dao.salvarCategoria(tipo6);
		dao.salvarCategoria(tipo7);
		dao.salvarCategoria(tipo8);
		dao.salvarCategoria(tipo9);

		dao.salvarProduto(produto1);
		dao.salvarProduto(produto2);
		dao.salvarProduto(produto3);
		dao.salvarProduto(produto4);
		dao.salvarProduto(produto5);
		dao.salvarProduto(produto6);
		dao.salvarProduto(produto7);

		dao.salvarCarrinho(carrinho1);
		dao.salvarCarrinho(carrinho2);
		dao.salvarCarrinho(carrinho3);

		dao.salvarFuncionario(Funcionario1);
		dao.salvarFuncionario(Funcionario2);
		dao.salvarFuncionario(Funcionario3);

	}
	@SuppressWarnings("unused")
	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

}
}

