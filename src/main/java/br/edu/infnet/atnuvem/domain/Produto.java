package br.edu.infnet.atnuvem.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TProduto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Cotacao> cotacoes;
	
	
	public Produto() {
		
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



	public List<Cotacao> getCotacoes() {
		return cotacoes;
	}



	public void setCotacoes(List<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
