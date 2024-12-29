package com.emsi.airbnb.IService;

import com.emsi.airbnb.Payload.Request.AnnonceRequest;
import com.emsi.airbnb.Payload.Response.AnnonceResponse;

import java.util.List;

public interface IAnnonceService {
    void saveAnnonce(AnnonceRequest annonceRequest);
    AnnonceResponse getAnnonceById(String annonceId);
    List<AnnonceResponse> getAllAnnonces();
    void updateAnnonce(String annonceId, AnnonceRequest annonceRequest);
    void deleteAnnonce(String annonceId);
}
