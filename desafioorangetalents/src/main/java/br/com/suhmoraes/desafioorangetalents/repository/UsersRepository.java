package br.com.suhmoraes.desafioorangetalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suhmoraes.desafioorangetalents.domain.UserEntity;

public interface UsersRepository  extends JpaRepository<UserEntity, String> {
 
}
