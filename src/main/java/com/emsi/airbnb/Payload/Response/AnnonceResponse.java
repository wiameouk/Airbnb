package com.emsi.airbnb.Payload.Response;

import com.emsi.airbnb.Enum.ECategory;
import com.emsi.airbnb.Enum.EFiltre;

import java.util.List;

public record AnnonceResponse(
    String id,
    String title,
    String description,
    Double price,
    List<EFiltre> filtres,
    ECategory category,
    String reservationId, 
    String locataireId, 
    String image
) {
}
