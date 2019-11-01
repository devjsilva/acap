package br.com.etec.acapi.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@ManyToOne
	private CategoriasProdutos tipo;
	private String descricao;
	private double preco;
	private Integer qtd;
	@Temporal(TemporalType.DATE)
	private Calendar dataValidade = Calendar.getInstance();
	@ManyToOne(fetch=FetchType.EAGER)
	private Fornecedor fornecedor;
	@ManyToOne(fetch=FetchType.EAGER)
	private Carrinho carrinho;
	
	// @Enumerated(EnumType.STRING)
	// private Categoria tipo;
	// public Categoria getTipo() {
	// return tipo;
	// }
	// public void setTipo(Categoria tipo) {
	// this.tipo = tipo;
	// }

	public Integer getId() {
		return id;
	}
	
	

	public Integer getQtd() {
		return qtd;
	}



	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}



	public CategoriasProdutos getTipo() {
		return tipo;
	}

	public void setTipo(CategoriasProdutos tipo) {
		this.tipo = tipo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}


	public Calendar getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
}

