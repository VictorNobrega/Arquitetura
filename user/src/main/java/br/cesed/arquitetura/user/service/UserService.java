package br.cesed.arquitetura.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.arquitetura.user.entity.Usuario;
import br.cesed.arquitetura.user.repository.UserRepository;
import br.cesed.arquitetura.user.service.exception.UserInvalidoException;

@Service
@Validated
public class UserService {

	@Autowired
	private UserRepository repository;

	public Usuario addUser(Usuario user) {

		return (Usuario) repository.save(user);
	}

	public List<Usuario> addUsers(List<Usuario> users) {

		return (List<Usuario>) repository.saveAll(users);
	}

	public Usuario modificarUser(Usuario user) throws UserInvalidoException {

		if (user == null) {
			throw new UserInvalidoException();
		}

		return (Usuario) repository.save(user);
	}

	public Optional<Usuario> buscarUser(Long id) throws UserInvalidoException {

		if (id == null) {
			throw new UserInvalidoException();
		}

		return repository.findById(id);
	}

	public List<Usuario> listarUsers() {

		return (List<Usuario>) repository.findAll();
	}

	public void deletarUser(Long id) throws UserInvalidoException {

		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
	}

}
