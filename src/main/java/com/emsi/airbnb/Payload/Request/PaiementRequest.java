package com.emsi.airbnb.Payload.Request;

import com.emsi.airbnb.Enum.EMethod;
import com.emsi.airbnb.Enum.EStatuts;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PaiementRequest(

    @NotNull
    Double amount, 

    @NotNull
    LocalDateTime paymentDate,

    @NotNull
    EStatuts paymentStatuts, 

    @NotNull
    EMethod paymentMethod, 

  
    String reservationId 
) {
}
