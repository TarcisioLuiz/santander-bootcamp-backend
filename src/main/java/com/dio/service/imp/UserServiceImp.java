package com.dio.service.imp;

import com.dio.domain.model.User;
import com.dio.domain.repository.UserRepository;
import com.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository repository;

    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User createUser) {
        if (repository.existsByAccount_Number(createUser.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exist");
        }
        return repository.save(createUser);
    }
}
