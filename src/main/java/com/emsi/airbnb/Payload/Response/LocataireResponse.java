package com.emsi.airbnb.Payload.Response;

import java.time.LocalDateTime;

public record LocataireResponse(
    String id,
    String username,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    String reservationId

) {
}
