package com.emsi.airbnb.Payload.Response;

import java.time.LocalDateTime;

import com.emsi.airbnb.Enum.EMethod;
import com.emsi.airbnb.Enum.EStatuts;

public record PaimentResponse(
    String id,
    Double amount,
    LocalDateTime paymentDate,
    EStatuts paymentStatuts,
    EMethod paymentMethod,
    String reservationId 
) {
}
