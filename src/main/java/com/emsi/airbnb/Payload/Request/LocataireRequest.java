package com.emsi.airbnb.Payload.Request;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

public record LocataireRequest(

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

    @NotNull
    String reservationId
) {
}
