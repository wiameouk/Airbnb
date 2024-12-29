package com.emsi.airbnb.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emsi.airbnb.Entity.Locataire;
import com.emsi.airbnb.Exception.LocataireNotFoundException;
import com.emsi.airbnb.IService.ILocataireService;
import com.emsi.airbnb.Payload.Mapper.LocataireMapper;
import com.emsi.airbnb.Payload.Request.LocataireRequest;
import com.emsi.airbnb.Payload.Response.LocataireResponse;
import com.emsi.airbnb.Repository.LocataireRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocataireService implements ILocataireService{
    private final LocataireRepository locataireRepository;
    private final LocataireMapper locataireMapper;

    @Override
    @Transactional
    public void saveLocataire(LocataireRequest locataireRequest) {
        Locataire locataire = locataireMapper.toLocataire(locataireRequest);
        locataireRepository.save(locataire);
    }

    @Override
    public LocataireResponse getLocataireById(String locataireId) {
       return locataireRepository.findById(UUID.fromString(locataireId))
            .map(locataireMapper::toLocataireResponse)
            .orElseThrow(() -> new LocataireNotFoundException("Cannot find locataire with id: " + locataireId));
    }

    @Override
    public List<LocataireResponse> getAllLocataires() {
            return locataireRepository.findAll()
            .stream()
            .map(locataireMapper::toLocataireResponse)
            .collect(Collectors.toList());
    }

    @Override
    public void updateLocataire(String locataireId, LocataireRequest locataireRequest) {
        Locataire locataire = locataireRepository.findById(UUID.fromString(locataireId))
        .orElseThrow(() -> new LocataireNotFoundException("Cannot find locataire with id: " + locataireId));
    
        locataire.setUsername(locataireRequest.username());
        locataire.setEmail(locataireRequest.email());
        locataire.setPassword(locataireRequest.password());
        locataire.setCreatedAt(locataireRequest.createdAt());
        locataire.setUpdatedAt(locataireRequest.updatedAt());
        locataireRepository.save(locataire);
    }

    @Override
    public void deleteLocataire(String locataireId) {
        if (locataireRepository.existsById(UUID.fromString(locataireId))) {
            locataireRepository.deleteById(UUID.fromString(locataireId));
        } else {
            throw new LocataireNotFoundException("Cannot find locataire with id: " + locataireId);
        }
    }
   
}
