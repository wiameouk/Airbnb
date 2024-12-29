package com.emsi.airbnb.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.emsi.airbnb.Enum.EMethod;
import com.emsi.airbnb.Enum.EStatuts;
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
@Table(name = "paiment")
public class Paiement {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double amount;
    
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private EStatuts paymentStatuts;

    @Enumerated(EnumType.STRING)
    private EMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "reservation_id") 
    private Reservation reservation;
}
