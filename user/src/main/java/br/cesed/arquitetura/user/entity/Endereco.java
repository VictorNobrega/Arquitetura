package br.cesed.arquitetura.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(schema = "user", sequenceName = "seq_endereco", name = "seq_endereco", allocationSize = 1, initialValue = 1)
@Table(name = "endereco", schema = "user")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	@Column(name = "id_endereco")
	private Long id;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "pais")
	private String pais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return rua;
	}

	public void setEndereco(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
