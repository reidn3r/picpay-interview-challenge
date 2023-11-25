package com.example.picpay.repository;

import com.example.picpay.model.User.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByCpf(String cpf);
}
