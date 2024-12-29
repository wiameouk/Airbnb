package com.emsi.airbnb.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.airbnb.Entity.Paiement;
import com.emsi.airbnb.Enum.EMethod;
import com.emsi.airbnb.Enum.EStatuts;
@Repository
public interface PaiementRepository extends JpaRepository<Paiement, UUID>{

    List<Paiement> findByPaymentStatuts(EStatuts paymentStatuts);

    List<Paiement> findByPaymentMethod(EMethod paymentMethod);

    List<Paiement> findByReservationId(UUID fromString);
    
}
