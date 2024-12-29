package com.emsi.airbnb.Payload.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record UserRequest(
    @NotBlank
    String username,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String password,

    @NotNull
    LocalDateTime createdAt,

    @NotNull
    LocalDateTime updatedAt,

    String reservationId 
) {
}
