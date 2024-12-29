package com.emsi.airbnb.IService;

import com.emsi.airbnb.Payload.Request.PaiementRequest;
import com.emsi.airbnb.Payload.Response.PaimentResponse;

import java.util.List;

public interface IPaiementService {
    void savePaiement(PaiementRequest paiementRequest);
    PaimentResponse getPaiementById(String paiementId);
    List<PaimentResponse> getAllPaiements();
    void updatePaiement(String paiementId, PaiementRequest paiementRequest);
    void deletePaiement(String paiementId);
   
}
