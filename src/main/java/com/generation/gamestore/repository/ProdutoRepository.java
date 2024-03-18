package com.generation.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gamestore.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
