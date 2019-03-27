package br.cesed.arquitetura.product.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.cesed.arquitetura.product.entity.Produto;
import br.cesed.arquitetura.product.exception.ProdutoInvalidoException;
import br.cesed.arquitetura.product.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@PostMapping
	public ResponseEntity<Produto> salvaUser(@Valid @RequestBody Produto produto) throws ProdutoInvalidoException {
		return new ResponseEntity<Produto>(service.addUser(produto), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Produto> modificarUser(@Valid @RequestBody Produto produto) throws ProdutoInvalidoException {
		
		Produto produtoRetorno = service.modificarUser(produto);
		return new ResponseEntity<Produto>(produtoRetorno, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> getUsers() {
		
		List<Produto> produto = service.listarUsers();
		return new ResponseEntity<List<Produto>>(produto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> getUser(@PathVariable Long id) throws ProdutoInvalidoException {
		
		Optional<Produto> produto = service.buscarUser(id);
		return new ResponseEntity<Optional<Produto>>(produto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletarUser(@PathVariable Long id) throws ProdutoInvalidoException {
		
		service.deletarProduto(id);
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}
	
}
