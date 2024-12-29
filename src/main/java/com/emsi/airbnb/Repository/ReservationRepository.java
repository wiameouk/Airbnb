package com.emsi.airbnb.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.airbnb.Entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {


}
