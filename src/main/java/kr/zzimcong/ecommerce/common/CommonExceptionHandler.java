package kr.zzimcong.ecommerce.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static kr.zzimcong.ecommerce.common.StatusCode.FAILED;
import static kr.zzimcong.ecommerce.common.StatusCode.STOCK_ZERO_EXCEPTION;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.ok(
                ApiResponseDto.failed(e.getMessage())
        );
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<?> illegalStateException(IllegalStateException e){
        return ResponseEntity.ok(
                ApiResponseDto.failed(e.getMessage())
        );
    }

    @ExceptionHandler(value = StockZeroException.class)
    public ResponseEntity<?> stockZeroException(StockZeroException e){
        return new ResponseEntity<>(
                new ApiResponseDto<>(STOCK_ZERO_EXCEPTION.getCode(), STOCK_ZERO_EXCEPTION.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
