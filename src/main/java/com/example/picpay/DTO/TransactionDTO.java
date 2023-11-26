package com.example.picpay.DTO;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionDTO(
                            @NotNull BigDecimal amount,
                            @NotNull Long payer_id,
                            @NotNull Long payee_id) {
}
