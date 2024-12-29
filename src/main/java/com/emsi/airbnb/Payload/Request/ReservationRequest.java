package com.emsi.airbnb.Payload.Request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservationRequest(

    @NotNull
    LocalDateTime starDate, 

    @NotNull
    LocalDateTime endDate

) {
}
