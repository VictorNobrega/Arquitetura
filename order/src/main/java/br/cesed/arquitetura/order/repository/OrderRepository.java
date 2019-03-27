package br.cesed.arquitetura.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.cesed.arquitetura.order.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
