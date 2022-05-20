package kr.zzimcong.ecommerce.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UserRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
