package kr.zzimcong.ecommerce.user.dto;

import kr.zzimcong.ecommerce.user.domain.User;
import kr.zzimcong.ecommerce.user.repository.UserRepository;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String email;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.email = user.getEmail();
    }
}
