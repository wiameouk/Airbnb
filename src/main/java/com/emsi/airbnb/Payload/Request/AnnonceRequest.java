package com.emsi.airbnb.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import com.emsi.airbnb.Enum.EFiltre;

import io.micrometer.common.lang.NonNull;

import com.emsi.airbnb.Enum.ECategory;


public record AnnonceRequest(

    @NotBlank
    @NotNull
    String title, 

    @NotBlank
    @NotNull
    String description, 

    @NotNull
    Double price, 

    @NotNull
    List<EFiltre> filtres, 

    @NotNull
    ECategory category, 
     
    @NonNull
    @NotBlank
    String reservationId, 

    @NonNull
    @NotBlank
    String locataireId,

    String image
    

){
    
}
