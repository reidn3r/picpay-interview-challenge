package com.example.picpay.controller;

import com.example.picpay.DTO.TransactionDTO;
import com.example.picpay.model.Transaction.TransactionModel;
import com.example.picpay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionModel> createTransaction(@RequestBody TransactionDTO data) throws Exception{
        TransactionModel newTransaction = this.transactionService.createTransaction(data);
        return ResponseEntity.status(HttpStatus.OK).body(newTransaction);
    }
}
