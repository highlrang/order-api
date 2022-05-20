package kr.zzimcong.ecommerce.user.service;

import kr.zzimcong.ecommerce.user.dto.UserRequestDto;

public interface UserService {
    void login(UserRequestDto dto); // session에 저장하기
}
