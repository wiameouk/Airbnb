package com.emsi.airbnb.IService;

import com.emsi.airbnb.Payload.Request.ReservationRequest;
import com.emsi.airbnb.Payload.Response.ReservationResponse;

import java.util.List;
import java.util.UUID;

public interface IReservationService {
    void saveReservation(ReservationRequest reservationRequest);
    ReservationResponse getReservationById(UUID reservationId);
    List<ReservationResponse> getAllReservations();
    void updateReservation(String reservationId, ReservationRequest reservationRequest);
    void deleteReservation(String reservationId);

}
