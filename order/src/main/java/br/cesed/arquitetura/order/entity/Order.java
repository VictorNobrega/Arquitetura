package br.cesed.arquitetura.order.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Order {

	private Long id;
	private List<Produto> produtos;
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
