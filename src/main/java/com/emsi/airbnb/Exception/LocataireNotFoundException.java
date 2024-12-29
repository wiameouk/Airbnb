package  com.emsi.airbnb.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT)
public class LocataireNotFoundException extends RuntimeException {
    public LocataireNotFoundException(String message)
    {
        super(message);
    }
    
}
