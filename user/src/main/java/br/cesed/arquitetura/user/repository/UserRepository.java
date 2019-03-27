package br.cesed.arquitetura.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.cesed.arquitetura.user.entity.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {

}
