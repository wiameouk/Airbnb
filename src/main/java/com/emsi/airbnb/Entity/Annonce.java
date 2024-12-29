package com.emsi.airbnb.Entity;

import java.util.List;
import java.util.UUID;

import com.emsi.airbnb.Enum.ECategory;
import com.emsi.airbnb.Enum.EFiltre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String description;
    
    private Double price;

    @Enumerated(EnumType.STRING)
    private List<EFiltre> filtres;

    @Enumerated(EnumType.STRING)
    private ECategory category;

    @OneToOne
    @JoinColumn(name = "reservation_id") 
    private Reservation reservation;

    @ManyToOne
    private Locataire locataire;

    private String image; 
}
