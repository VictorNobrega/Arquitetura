package br.cesed.arquitetura.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.cesed.arquitetura.product.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
