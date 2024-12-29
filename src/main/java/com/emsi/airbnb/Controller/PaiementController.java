package com.emsi.airbnb.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsi.airbnb.Payload.Request.PaiementRequest;
import com.emsi.airbnb.Payload.Response.PaimentResponse;
import com.emsi.airbnb.Service.PaiementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @PostMapping
    public ResponseEntity<Void> savePaiement(@RequestBody @Valid PaiementRequest paiementRequest) {
        paiementService.savePaiement(paiementRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaimentResponse> getPaiementById(@PathVariable("id") String paiementId) {
        return ResponseEntity.ok(paiementService.getPaiementById(paiementId));
    }

    @GetMapping
    public ResponseEntity<List<PaimentResponse>> getAllPaiements() {
        return ResponseEntity.ok(paiementService.getAllPaiements());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePaiement(
            @PathVariable("id") String paiementId,
            @RequestBody @Valid PaiementRequest paiementRequest) {
        paiementService.updatePaiement(paiementId, paiementRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable("id") String paiementId) {
        paiementService.deletePaiement(paiementId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

  
 
    
}
