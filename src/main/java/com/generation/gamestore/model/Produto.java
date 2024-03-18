package com.generation.gamestore.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")

public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é Obrigatório!")
	@Size(min = 3, max = 100, message = "O atributo nome deve conter no mínimo 03 e no máximo 100 caracteres")
	private String nome;
	
	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao;
	
	@NotNull(message = "O Atributo Preço é obrigatório")
	private BigDecimal preco;
	
	@NotNull(message = "O Atributo Quantidade é obrigatório")
	private Integer quantidade;
		
	@UpdateTimestamp
	@Column(name = "data_produto")
	private LocalDateTime dataProduto;

	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getDataProduto() {
		return dataProduto;
	}

	public void setDataProduto(LocalDateTime dataProduto) {
		this.dataProduto = dataProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
