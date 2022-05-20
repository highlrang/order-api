package kr.zzimcong.ecommerce.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static kr.zzimcong.ecommerce.common.StatusCode.FAILED;
import static kr.zzimcong.ecommerce.common.StatusCode.SUCCESS;

@Getter
public class ApiResponseDto<T> {
    private String code;
    private String message;
    private T content;

    public ApiResponseDto(String code, String message){
        this.code = code;
        this.message = message;
    }

    public ApiResponseDto(String code, String message, T content){
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public static ApiResponseDto<?> success(){
        return new ApiResponseDto<>(SUCCESS.getCode(), SUCCESS.getMessage());
    }

    public static ApiResponseDto<?> success(Object content){
        return new ApiResponseDto<>(SUCCESS.getCode(), SUCCESS.getMessage(), content);
    }

    public static ApiResponseDto<?> failed(){
        return new ApiResponseDto<>(FAILED.getCode(), FAILED.getMessage());
    }

    public static ApiResponseDto<?> failed(Object content){
        return new ApiResponseDto<>(FAILED.getCode(), FAILED.getMessage(), content);
    }
}
