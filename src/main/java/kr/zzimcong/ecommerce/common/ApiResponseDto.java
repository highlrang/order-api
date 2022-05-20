package kr.zzimcong.ecommerce.common;

import lombok.Getter;

@Getter
public class ApiResponseDto<T> {
    private String code;
    private String message;
    private T content;

    public ApiResponseDto(String code, String message, T content){
        this.code = code;
        this.message = message;
        this.content = content;
    }
}
