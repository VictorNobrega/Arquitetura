package br.cesed.arquitetura.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.arquitetura.product.entity.Produto;
import br.cesed.arquitetura.product.exception.ProdutoInvalidoException;
import br.cesed.arquitetura.product.repository.ProdutoRepository;

@Service
@Validated
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto addUser(Produto produto) {

		return (Produto) produtoRepository.save(produto);
	}

	public List<Produto> addUsers(List<Produto> produto) {

		return (List<Produto>) produtoRepository.saveAll(produto);
	}

	public Produto modificarUser(Produto produto) throws ProdutoInvalidoException {

		if (produto == null) {
			throw new ProdutoInvalidoException();
		}

		return (Produto) produtoRepository.save(produto);
	}

	public Optional<Produto> buscarUser(Long id) throws ProdutoInvalidoException {

		if (id == null) {
			throw new ProdutoInvalidoException();
		}

		return produtoRepository.findById(id);
	}

	public List<Produto> listarUsers() {

		return (List<Produto>) produtoRepository.findAll();
	}

	public void deletarProduto(Long id) throws ProdutoInvalidoException {

		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
		}
	}
	
}
