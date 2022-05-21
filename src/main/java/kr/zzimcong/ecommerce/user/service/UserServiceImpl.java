package kr.zzimcong.ecommerce.user.service;

import kr.zzimcong.ecommerce.user.domain.User;
import kr.zzimcong.ecommerce.user.dto.UserRequestDto;
import kr.zzimcong.ecommerce.user.dto.UserResponseDto;
import kr.zzimcong.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

import static kr.zzimcong.ecommerce.common.StatusCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final HttpSession session;

    @Override
    public void login(UserRequestDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException(USER_NOT_FOUND.getMessage()));
        user.checkPassword(dto.getPassword());
        session.setAttribute("user", new UserResponseDto(user));
    }
}
