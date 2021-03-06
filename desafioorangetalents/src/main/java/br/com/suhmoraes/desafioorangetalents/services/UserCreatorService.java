package br.com.suhmoraes.desafioorangetalents.services;


import org.springframework.stereotype.Service;

import br.com.suhmoraes.desafioorangetalents.domain.UserEntity;
import br.com.suhmoraes.desafioorangetalents.repository.UsersRepository;


@Service
public class UserCreatorService {
    private final UsersRepository repository;

    public UserCreatorService(final UsersRepository repository) {
        this.repository = repository;
    }

    public UserEntity create(UserEntity entity) {
    	return this.repository.save(entity);
    }

}