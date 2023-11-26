package com.example.picpay.DTO;

import com.example.picpay.model.User.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record UserDTO( @NotBlank String firstname,
                       @NotBlank String lastname,
                       @NotBlank @CPF String cpf,
                       @NotNull @PositiveOrZero BigDecimal balance,
                       @NotBlank @Email String email,
                       @NotBlank String password,
                       @NotNull UserType usertype) {
}
