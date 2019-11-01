package br.com.etec.acapi.modelo;

import java.util.Calendar;

public class Vendas {

	private Compra compra;
	private Calendar data;
	private Integer valor;
	private String nome;
	
	
	public Vendas(String nome, Integer valor) {
		
		this.nome = nome;
		this.valor = valor;
	}
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Calendar getData() {
		return data;
	}



	public void setData(Calendar data) {
		this.data = data;
	}



	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
