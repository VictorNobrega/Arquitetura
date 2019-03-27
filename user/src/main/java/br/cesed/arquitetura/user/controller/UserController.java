package br.cesed.arquitetura.user.controller;

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

import br.cesed.arquitetura.user.entity.Usuario;
import br.cesed.arquitetura.user.service.UserService;
import br.cesed.arquitetura.user.service.exception.UserInvalidoException;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<Usuario> salvaUser(@Valid @RequestBody Usuario user) throws UserInvalidoException {
		return new ResponseEntity<Usuario>(service.addUser(user), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Usuario> modificarUser(@Valid @RequestBody Usuario user) throws UserInvalidoException {

		Usuario UserRetorno = service.modificarUser(user);
		return new ResponseEntity<Usuario>(UserRetorno, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> getUsers() {

		List<Usuario> Users = service.listarUsers();
		return new ResponseEntity<List<Usuario>>(Users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> getUser(@PathVariable Long id) throws UserInvalidoException {

		Optional<Usuario> User = service.buscarUser(id);
		return new ResponseEntity<Optional<Usuario>>(User, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletarUser(@PathVariable Long id) throws UserInvalidoException {

		service.deletarUser(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}

}
