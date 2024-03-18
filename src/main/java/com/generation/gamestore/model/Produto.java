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
import lombok.Data;

@Entity
@Table(name = "tb_produtos")
@Data
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
}
