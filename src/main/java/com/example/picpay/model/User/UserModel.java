package com.example.picpay.model.User;

import com.example.picpay.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String cpf;

    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType usertype;

    public UserModel(UserDTO data){
        this.firstname = data.firstname();
        this.lastname = data.lastname();
        this.cpf = data.cpf();
        this.email = data.email();
        this.password = data.password();
        this.balance = data.balance();
        this.usertype = data.usertype();
    }
}
