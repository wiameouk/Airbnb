package  com.emsi.airbnb.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AnnnonceNotFoundException extends RuntimeException {
    public AnnnonceNotFoundException(String message){
        super(message);
    }
    
}
