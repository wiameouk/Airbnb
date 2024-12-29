package com.emsi.airbnb.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsi.airbnb.Entity.Locataire;
import org.springframework.stereotype.Repository;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, UUID>{
    
}
