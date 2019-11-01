package br.com.etec.acapi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Fornecedor {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
	    private String nome;
	    @JoinColumn(unique = true)
		private String CNPJ;
	    private String descricao;
	    
	    public Fornecedor() {
	    	    	
	    }
	    
		public Integer getId() {
			return id;
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
		public String getCNPJ() {
			return CNPJ;
		}
		public void setCNPJ(String cNPJ) {
			CNPJ = cNPJ;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

}
