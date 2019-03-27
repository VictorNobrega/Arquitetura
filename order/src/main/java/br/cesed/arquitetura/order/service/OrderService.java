package br.cesed.arquitetura.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.arquitetura.order.entity.Order;
import br.cesed.arquitetura.order.exception.OrderInvalidoException;
import br.cesed.arquitetura.order.repository.OrderRepository;

@Service
@Validated
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order addOrder(Order order) {

		return (Order) orderRepository.save(order);
	}

	public List<Order> addOrders(List<Order> order) {

		return (List<Order>) orderRepository.saveAll(order);
	}

	public Order modificarOrder(Order order) throws OrderInvalidoException {

		if (order == null) {
			throw new OrderInvalidoException();
		}

		return (Order) orderRepository.save(order);
	}

	public Optional<Order> buscarOrder(Long id) throws OrderInvalidoException {

		if (id == null) {
			throw new OrderInvalidoException();
		}

		return orderRepository.findById(id);
	}

	public List<Order> listarOrders() {

		return (List<Order>) orderRepository.findAll();
	}

	public void deletarOrder(Long id) throws OrderInvalidoException {

		if (orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
		}
	}

}
