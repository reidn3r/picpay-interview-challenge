package com.example.picpay.service;

import com.example.picpay.DTO.UserDTO;
import com.example.picpay.model.User.UserModel;
import com.example.picpay.model.User.UserType;
import com.example.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(UserModel payer, BigDecimal amount) throws Exception{
        if(payer.getUsertype() != UserType.USER){
            throw new Exception("Usuário nao autorizado a realizar a transacao");
        }

        if(payer.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public UserModel findUserById(Long id) throws Exception{
        UserModel foundUser = this.repository.findUserById(id);
        if(foundUser == null) throw new Exception("Usuario nao encontrado");
        return foundUser;
    }


    public void saveUser(UserModel user){
        this.repository.save(user);
    }

    public ResponseEntity<UserModel> createUser(UserDTO user) throws Exception{
        UserModel foundCpf = this.repository.findByCpf(user.cpf());
        if(foundCpf != null) throw new Exception("CPF ja cadastrado");

        UserModel foundEmail = this.repository.findByEmail(user.email());
        if(foundEmail != null) throw new Exception("Email ja cadastrado");

        //Cria novo dado somente se email e cpf do usuário nao forem registrados
        UserModel newUser = new UserModel(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newUser));
    }

    public List<UserModel> getAllUsers(){
        return this.repository.findAll();
    }
}
