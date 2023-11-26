package com.example.picpay.controller;

import com.example.picpay.DTO.UserDTO;
import com.example.picpay.model.User.UserModel;
import com.example.picpay.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
@Tag(name = "User Controller")
public class UserController {
    @Autowired
    UserService userService;

    @Operation(
            description = "Endpoint que registra novo usuário",
            parameters = {
                    @Parameter(name = "firstname", description = "Primeiro nome do usuario"),
                    @Parameter(name = "lastname", description = "Ultimo nome do usuario"),
                    @Parameter(name = "cpf", description = "CPF do usuario"),
                    @Parameter(name = "balance", description = "Quantidade monetária inicial do usuário"),
                    @Parameter(name = "email", description = "Email do usuario"),
                    @Parameter(name = "password", description = "Senha de registro do usuario"),
                    @Parameter(name = "usertype", description = "Tipo de usuario, variando entre USER (Usuário comum) ou MERCHAN (Lojista)"),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Sucesso. Usuário criado"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor. Usuário nao criado"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserDTO data) throws Exception{
            return this.userService.createUser(data);
    }

    @Operation(
            description = "Lista todos usuários cadastrados",
            responses = {
                    @ApiResponse(
                            description = "Sucesso",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
    }
}
