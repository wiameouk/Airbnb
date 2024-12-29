package com.emsi.airbnb.IService;

import com.emsi.airbnb.Payload.Request.LocataireRequest;
import com.emsi.airbnb.Payload.Response.LocataireResponse;

import java.util.List;

public interface ILocataireService {
    void saveLocataire(LocataireRequest locataireRequest);
    LocataireResponse getLocataireById(String locataireId);
    List<LocataireResponse> getAllLocataires();
    void updateLocataire(String locataireId, LocataireRequest locataireRequest);
    void deleteLocataire(String locataireId);
    

}
