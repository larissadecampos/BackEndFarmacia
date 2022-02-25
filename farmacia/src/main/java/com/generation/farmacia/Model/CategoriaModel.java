package com.generation.farmacia.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; //ctrl+shift+o
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria") // nome que eu quiser fdc

public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automático
	private long id;

	@NotBlank
	@Size(min = 4, max = 120)
	private String titulo;

	@NotBlank
	@Size(min = 4, max = 120)
	private String descricao;

	@OneToMany(mappedBy = "categoria",  cascade = CascadeType.ALL) //cascate se refere a atualizações do código no banco de dados
	@JsonIgnoreProperties("categoria")  //parar loop infinito
	private List<ProdutoModel> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

		
}
