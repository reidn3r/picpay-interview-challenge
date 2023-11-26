package com.example.picpay.model.Transaction;

import com.example.picpay.DTO.TransactionDTO;
import com.example.picpay.model.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@Entity
@Table(name="tb_transactions")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private UserModel payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private UserModel payee;

    private LocalDateTime timestamp_trasaction;

    public TransactionModel(TransactionDTO data, UserModel payer, UserModel payee){
        this.amount = data.amount();
        this.payer = payer;
        this.payee = payee;
        this.timestamp_trasaction = LocalDateTime.now();
    }
}
