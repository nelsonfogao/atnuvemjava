package br.edu.infnet.atnuvem.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "TCotacao")
public class Cotacao implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Float valor;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "cotacoes")
	private List<Produto> produtos;
	
	
	public Cotacao() {
		
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Float getValor() {
		return valor;
	}




	public void setValor(Float valor) {
		this.valor = valor;
	}




	public List<Produto> getProdutos() {
		return produtos;
	}




	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
