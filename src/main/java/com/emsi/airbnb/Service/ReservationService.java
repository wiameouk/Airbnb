package com.emsi.airbnb.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.Reservation;
import com.emsi.airbnb.Exception.ReservationNotFounException;
import com.emsi.airbnb.IService.IReservationService;
import com.emsi.airbnb.Payload.Mapper.ReservationMapper;
import com.emsi.airbnb.Payload.Request.ReservationRequest;
import com.emsi.airbnb.Payload.Response.ReservationResponse;
import com.emsi.airbnb.Repository.ReservationRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    @Transactional
    public void saveReservation(ReservationRequest reservationRequest) {

        Reservation reservation = reservationMapper.toReservation(reservationRequest);

        reservationRepository.save(reservation);
    }

    @Override
    public ReservationResponse getReservationById(UUID reservationId) {
        return reservationRepository.findById(reservationId)
        .map(reservationMapper::toReservationResponse)
        .orElseThrow(() -> new ReservationNotFounException("Cannot find reservation with id: " + reservationId));
    }

    @Override
    public List<ReservationResponse> getAllReservations() {
        try {
            return reservationRepository.findAll()
                    .stream()
                    .map(reservationMapper::toReservationResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching reservations: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateReservation(String reservationId, ReservationRequest reservationRequest) {
        Reservation reservation = reservationRepository.findById(UUID.fromString(reservationId))
                .orElseThrow(() -> new ReservationNotFounException("Cannot find reservation with id: " + reservationId));



        reservation.setStarDate(reservationRequest.starDate());
        reservation.setEndDate(reservationRequest.endDate());

        reservationRepository.save(reservation);
    }
    @Override
    @Transactional
    public void deleteReservation(String reservationId) {
        if (reservationRepository.existsById(UUID.fromString(reservationId))) {
            reservationRepository.deleteById(UUID.fromString(reservationId));
        } else {
            throw new ReservationNotFounException("Cannot find reservation with id: " + reservationId);
        }
    }
  
}
