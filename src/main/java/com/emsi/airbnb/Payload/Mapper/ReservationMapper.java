package com.emsi.airbnb.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.Reservation;
import com.emsi.airbnb.Payload.Request.ReservationRequest;
import com.emsi.airbnb.Payload.Response.ReservationResponse;
@Service
public class ReservationMapper {

    public Reservation toReservation(ReservationRequest reservationRequest) {
        return Reservation.builder()
                .starDate(reservationRequest.starDate())
                .endDate(reservationRequest.endDate())
                .build();
    }
       
    public ReservationResponse toReservationResponse(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId().toString(),
                reservation.getStarDate(),  
                reservation.getEndDate()
        );
    }
}

