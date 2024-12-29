package  com.emsi.airbnb.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PaimentNotFoundException extends RuntimeException{
    public PaimentNotFoundException(String message){
        super(message);
    }
    
}
