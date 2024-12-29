package com.emsi.airbnb.Controller;

import com.emsi.airbnb.Payload.Request.ReservationRequest;
import com.emsi.airbnb.Payload.Response.ReservationResponse;
import com.emsi.airbnb.Service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Void> saveNewReservation(@RequestBody @Valid ReservationRequest reservationRequest) {
        reservationService.saveReservation(reservationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> findAllReservations() {
        List<ReservationResponse> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);    
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> findReservationById(@PathVariable("id") String reservationId) {
        UUID reservationUUID = UUID.fromString(reservationId);
        return ResponseEntity.ok(reservationService.getReservationById(reservationUUID));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservation(
            @PathVariable("id") String reservationId,
            @RequestBody @Valid ReservationRequest reservationRequest) {
        reservationService.updateReservation(reservationId, reservationRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") String reservationId) {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
