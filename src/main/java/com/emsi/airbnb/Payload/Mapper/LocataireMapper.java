package com.emsi.airbnb.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.Locataire;
import com.emsi.airbnb.Payload.Request.LocataireRequest;
import com.emsi.airbnb.Payload.Response.LocataireResponse;

@Service
public class LocataireMapper {

    public Locataire toLocataire(LocataireRequest locataireRequest) {
        return Locataire.builder()
                .username(locataireRequest.username())
                .email(locataireRequest.email())
                .password(locataireRequest.password())
                .createdAt(locataireRequest.createdAt())
                .updatedAt(locataireRequest.updatedAt())
                .build();
    }

    public LocataireResponse toLocataireResponse(Locataire locataire) {
        String reservationId = (locataire.getReservation() != null) ? locataire.getReservation().getId().toString() : null;

        return new LocataireResponse(
                locataire.getId().toString(),
                locataire.getUsername(),
                locataire.getEmail(),
                locataire.getCreatedAt(),
                locataire.getUpdatedAt(),
                reservationId 
        );
    }
}
