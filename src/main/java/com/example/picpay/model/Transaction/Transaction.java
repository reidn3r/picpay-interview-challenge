package com.example.picpay.model.Transaction;

import com.example.picpay.model.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@Entity
@Table(name="tb_transactions")
public class Transaction {
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

    private LocalDateTime timestamp;
}
