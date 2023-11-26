package com.example.picpay.controller;

import com.example.picpay.DTO.TransactionDTO;
import com.example.picpay.model.Transaction.TransactionModel;
import com.example.picpay.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@Tag(name="Transaction Controller")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(
           description = "Endpoint que registra nova transação",
            parameters = {
                   @Parameter(name = "amount", description = "Valor da transação"),
                   @Parameter(name = "payer_id", description = "Id do pagador"),
                   @Parameter(name = "payee_id", description = "Id do recebedor"),
            },
            responses = {
                   @ApiResponse(
                           responseCode = "200",
                           description = "Sucesso. Transação realizada"
                   ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor. Transação não realizada"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<TransactionModel> createTransaction(@RequestBody TransactionDTO data) throws Exception{
        TransactionModel newTransaction = this.transactionService.createTransaction(data);
        return ResponseEntity.status(HttpStatus.OK).body(newTransaction);
    }
}
