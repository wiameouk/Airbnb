package com.emsi.airbnb.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsi.airbnb.Payload.Request.LocataireRequest;
import com.emsi.airbnb.Payload.Response.LocataireResponse;
import com.emsi.airbnb.Service.LocataireService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/locataires")
@RequiredArgsConstructor
public class LocataireController {

    private final LocataireService locataireService;

    @PostMapping
    public ResponseEntity<Void> saveNewLocataire(@RequestBody @Valid LocataireRequest locataireRequest) {
        locataireService.saveLocataire(locataireRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<LocataireResponse>> findAllLocataires() {
        return ResponseEntity.ok(locataireService.getAllLocataires());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocataireResponse> findLocataireById(@PathVariable("id") String locataireId) {
        return ResponseEntity.ok(locataireService.getLocataireById(locataireId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLocataire(
            @PathVariable("id") String locataireId,
            @RequestBody @Valid LocataireRequest locataireRequest) {
        locataireService.updateLocataire(locataireId, locataireRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocataire(@PathVariable("id") String locataireId) {
        locataireService.deleteLocataire(locataireId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
