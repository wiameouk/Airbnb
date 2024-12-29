package com.emsi.airbnb.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.Paiement;
import com.emsi.airbnb.Entity.Reservation;
import com.emsi.airbnb.Exception.PaimentNotFoundException;
import com.emsi.airbnb.IService.IPaiementService;
import com.emsi.airbnb.Payload.Mapper.PaiementMapper;
import com.emsi.airbnb.Payload.Request.PaiementRequest;
import com.emsi.airbnb.Payload.Response.PaimentResponse;
import com.emsi.airbnb.Repository.PaiementRepository;
import com.emsi.airbnb.Repository.ReservationRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class PaiementService implements IPaiementService{

    private final PaiementRepository paiementRepository;
    private final ReservationRepository reservationRepository;
    private final PaiementMapper paiementMapper;
    
    @Transactional
    @Override
    public void savePaiement(PaiementRequest paiementRequest) {
        Reservation reservation = reservationRepository.findById(UUID.fromString(paiementRequest.reservationId()))
        .orElseThrow(() -> new PaimentNotFoundException("Réservation non trouvée"));
        Paiement paiement = paiementMapper.toPaiement(paiementRequest);
        paiement.setReservation(reservation);
        paiementRepository.save(paiement);
    }

    @Override
    public PaimentResponse getPaiementById(String paiementId) {
        Paiement paiement = paiementRepository.findById(UUID.fromString(paiementId))
        .orElseThrow(() -> new PaimentNotFoundException("Paiement non trouvé"));
        return paiementMapper.toPaiementResponse(paiement);
    }

    @Override
    public List<PaimentResponse> getAllPaiements() {
        List<Paiement> paiements = paiementRepository.findAll();
        return paiements.stream()
                .map(paiementMapper::toPaiementResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updatePaiement(String paiementId, PaiementRequest paiementRequest) {
        Paiement paiement = paiementRepository.findById(UUID.fromString(paiementId))
        .orElseThrow(() -> new PaimentNotFoundException("Paiement non trouvé"));

        paiement.setAmount(paiementRequest.amount());
        paiement.setPaymentDate(paiementRequest.paymentDate());
        paiement.setPaymentStatuts(paiementRequest.paymentStatuts());
        paiement.setPaymentMethod(paiementRequest.paymentMethod());

        paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiement(String paiementId) {
        Paiement paiement = paiementRepository.findById(UUID.fromString(paiementId))
                .orElseThrow(() -> new PaimentNotFoundException("Paiement non trouvé"));
                 paiementRepository.delete(paiement);
    }

  

 

  
}
