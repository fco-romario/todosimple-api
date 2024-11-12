package br.com.romario.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romario.todosimple.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
