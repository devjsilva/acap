package br.com.etec.acapi.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double valorFinal;
    private int totalDeCarrinhos;
    @JoinColumn(unique = true)
    private int numeroDeRegistro;
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Produto> produtos;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	public int getTotalDeCarrinhos() {
		return totalDeCarrinhos;
	}
	public void setTotalDeCarrinhos(int totalDeCarrinhos) {
		this.totalDeCarrinhos = totalDeCarrinhos;
	}
	public int getNumeroDeRegistro() {
		return numeroDeRegistro;
	}
	public void setNumeroDeRegistro(int numeroDeRegistro) {
		this.numeroDeRegistro = numeroDeRegistro;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
    
}
