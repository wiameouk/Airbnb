package com.emsi.airbnb.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.Annonce;
import com.emsi.airbnb.Entity.Locataire;
import com.emsi.airbnb.Entity.Reservation;
import com.emsi.airbnb.Exception.AnnnonceNotFoundException;
import com.emsi.airbnb.IService.IAnnonceService;
import com.emsi.airbnb.Payload.Mapper.AnnonceMapper;
import com.emsi.airbnb.Payload.Request.AnnonceRequest;
import com.emsi.airbnb.Payload.Response.AnnonceResponse;
import  com.emsi.airbnb.Repository.AnnnonceRepository;



import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AnnonceService implements IAnnonceService {
    private final AnnnonceRepository annonceRepository;
    private final AnnonceMapper annonceMapper;

    @Override
    @Transactional
    public void saveAnnonce(AnnonceRequest annonceRequest) {
        Annonce annonce = annonceMapper.toAnnonce(annonceRequest);
        annonceRepository.save(annonce);
    }

    @Override
    public AnnonceResponse getAnnonceById(String annonceId) {
        return annonceRepository.findById(UUID.fromString(annonceId))
            .map(annonceMapper::toAnnonceResponse)
            .orElseThrow(() -> new AnnnonceNotFoundException("Cannot find annonce with id: " + annonceId));
    }

    @Override
    public List<AnnonceResponse> getAllAnnonces() {
       return annonceRepository.findAll()
            .stream()
            .map(annonceMapper::toAnnonceResponse)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateAnnonce(String annonceId, AnnonceRequest annonceRequest) {
        Annonce annonce = annonceRepository.findById(UUID.fromString(annonceId))
            .orElseThrow(() -> new AnnnonceNotFoundException("Cannot find annonce with id: " + annonceId));
        
        annonce.setTitle(annonceRequest.title());
        annonce.setDescription(annonceRequest.description());
        annonce.setPrice(annonceRequest.price());
        annonce.setFiltres(annonceRequest.filtres());
        annonce.setCategory(annonceRequest.category());
        annonce.setImage(annonceRequest.image());
        
        if (annonceRequest.reservationId() != null) {
            annonce.setReservation(new Reservation()); 
        }
        
        if (annonceRequest.locataireId() != null) {
            annonce.setLocataire(new Locataire()); 
        }

        annonceRepository.save(annonce);
    }

    @Override
    @Transactional
    public void deleteAnnonce(String annonceId) {
        if (annonceRepository.existsById(UUID.fromString(annonceId))) {
            annonceRepository.deleteById(UUID.fromString(annonceId));
        } else {
            throw new AnnnonceNotFoundException("Cannot find annonce with id: " + annonceId);
        }
    }
      
}
