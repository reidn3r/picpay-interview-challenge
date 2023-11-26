package com.example.picpay.repository;

import com.example.picpay.model.User.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByCpf(String cpf);
    UserModel findUserById(Long id);
    UserModel findByEmail(String email);
}
