package com.example.picpay.repository;

import com.example.picpay.model.Transaction.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionReporitory extends JpaRepository<TransactionModel, Long> {
}
