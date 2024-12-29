package com.emsi.airbnb.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.emsi.airbnb.Payload.Request.AnnonceRequest;
import com.emsi.airbnb.Payload.Response.AnnonceResponse;
import com.emsi.airbnb.Service.AnnonceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/annonces")
@RequiredArgsConstructor
public class AnnonceController {

    private final AnnonceService annonceService;

    @PostMapping
    public ResponseEntity<Void> saveNewAnnonce(@RequestBody @Valid AnnonceRequest annonceRequest) {
        annonceService.saveAnnonce(annonceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<AnnonceResponse>> findAllAnnonces() {
        return ResponseEntity.ok(annonceService.getAllAnnonces());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnonceResponse> findAnnonceById(@PathVariable("id") String annonceId) {
        return ResponseEntity.ok(annonceService.getAnnonceById(annonceId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAnnonce(
            @PathVariable("id") String annonceId,
            @RequestBody @Valid AnnonceRequest annonceRequest) {
        annonceService.updateAnnonce(annonceId, annonceRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable("id") String annonceId) {
        annonceService.deleteAnnonce(annonceId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
