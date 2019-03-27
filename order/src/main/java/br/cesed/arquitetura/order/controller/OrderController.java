package br.cesed.arquitetura.order.controller;

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

import br.cesed.arquitetura.order.entity.Order;
import br.cesed.arquitetura.order.exception.OrderInvalidoException;
import br.cesed.arquitetura.order.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping
	public ResponseEntity<Order> salvaOrder(@Valid @RequestBody Order order) throws OrderInvalidoException {
		return new ResponseEntity<Order>(service.addOrder(order), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Order> modificarOrder(@Valid @RequestBody Order order) throws OrderInvalidoException {

		Order OrderRetorno = service.modificarOrder(order);
		return new ResponseEntity<Order>(OrderRetorno, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Order>> getOrders() {

		List<Order> Orders = service.listarOrders();
		return new ResponseEntity<List<Order>>(Orders, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Order>> getOrder(@PathVariable Long id) throws OrderInvalidoException {

		Optional<Order> Order = service.buscarOrder(id);
		return new ResponseEntity<Optional<Order>>(Order, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Order> deletarOrder(@PathVariable Long id) throws OrderInvalidoException {

		service.deletarOrder(id);
		return new ResponseEntity<Order>(HttpStatus.OK);
	}

}
