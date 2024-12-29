package com.emsi.airbnb.Payload.Mapper;

import org.springframework.stereotype.Service;
import com.emsi.airbnb.Entity.Annonce;
import com.emsi.airbnb.Entity.Reservation;
import com.emsi.airbnb.Entity.Locataire;
import com.emsi.airbnb.Payload.Request.AnnonceRequest;
import com.emsi.airbnb.Payload.Response.AnnonceResponse;

@Service
public class AnnonceMapper {

    public Annonce toAnnonce(AnnonceRequest annonceRequest) {
        return Annonce.builder()
                .title(annonceRequest.title())
                .description(annonceRequest.description())
                .price(annonceRequest.price())
                .filtres(annonceRequest.filtres())
                .category(annonceRequest.category())
                .reservation(annonceRequest.reservationId() != null ? new Reservation() : null) 
                .locataire(annonceRequest.locataireId() != null ? new Locataire() : null) 
                .image(annonceRequest.image())
                .build();
    }

    public AnnonceResponse toAnnonceResponse(Annonce annonce) {
        return new AnnonceResponse(
                annonce.getId().toString(),
                annonce.getTitle(),
                annonce.getDescription(),
                annonce.getPrice(),
                annonce.getFiltres(),
                annonce.getCategory(),
                annonce.getReservation().getId().toString(),
                annonce.getLocataire() != null ? annonce.getLocataire().getId().toString() : null,
                annonce.getImage()
        );
    }
}
