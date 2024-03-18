package com.generation.gamestore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamestore.model.Categoria;
import com.generation.gamestore.repository.CategoriaRepository;


@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

		@Autowired
		private CategoriaRepository categoriaRepository;

		@GetMapping
		public ResponseEntity<List<Categoria>> getAll() {
			return ResponseEntity.ok(categoriaRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> getById(@PathVariable Long id) {
			return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
}
