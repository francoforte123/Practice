package Practices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK)
public class NotFoundException extends RuntimeException{

    private String message;
    public NotFoundException(String smg) {
        super(smg);
        this.message= smg;
    }
}
