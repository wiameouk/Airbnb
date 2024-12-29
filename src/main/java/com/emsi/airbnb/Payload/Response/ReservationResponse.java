package com.emsi.airbnb.Payload.Response;

import java.time.LocalDateTime;

public record ReservationResponse(
    String id,
    LocalDateTime starDate,
    LocalDateTime endDate
) {
}
