package com.dio.service;
import com.dio.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User createUser);


}
