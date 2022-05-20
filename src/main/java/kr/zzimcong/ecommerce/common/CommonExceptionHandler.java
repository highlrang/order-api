package kr.zzimcong.ecommerce.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //?
public class CommonExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<?> illegalException(){
        return null;
    }
}
