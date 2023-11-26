package com.example.picpay.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NotificationDTO(@Email String email,
                              @NotBlank String message) {
}
