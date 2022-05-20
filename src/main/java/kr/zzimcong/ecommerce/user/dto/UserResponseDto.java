package kr.zzimcong.ecommerce.user.dto;

import kr.zzimcong.ecommerce.user.repository.UserRepository;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String email;

    public UserResponseDto(Long id, String email){
        this.id = id;
        this.email = email;
    }
}
