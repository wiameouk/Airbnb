package com.emsi.airbnb.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.Paiement;
import com.emsi.airbnb.Payload.Request.PaiementRequest;
import com.emsi.airbnb.Payload.Response.PaimentResponse;

@Service
public class PaiementMapper {

    public Paiement toPaiement(PaiementRequest paiementRequest) {
        return Paiement.builder()
                .amount(paiementRequest.amount())
                .paymentDate(paiementRequest.paymentDate())
                .paymentStatuts(paiementRequest.paymentStatuts())
                .paymentMethod(paiementRequest.paymentMethod())
                .build();
    }

    public PaimentResponse toPaiementResponse(Paiement paiement) {
        return new PaimentResponse(
                paiement.getId().toString(),
                paiement.getAmount(),
                paiement.getPaymentDate(),
                paiement.getPaymentStatuts(),
                paiement.getPaymentMethod(),
                paiement.getReservation().getId().toString()
        );
    }
}
