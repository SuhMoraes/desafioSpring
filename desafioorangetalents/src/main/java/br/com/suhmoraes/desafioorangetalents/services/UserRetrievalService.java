package br.com.suhmoraes.desafioorangetalents.services;

import org.springframework.stereotype.Service;

import br.com.suhmoraes.desafioorangetalents.domain.UserEntity;
import br.com.suhmoraes.desafioorangetalents.repository.UsersRepository;

@Service
public class UserRetrievalService {
    private final UsersRepository repository;

    public UserRetrievalService(final UsersRepository repository) {
        this.repository = repository;
    }

    public UserEntity findById(String id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário Não encontrado"));
    }
}