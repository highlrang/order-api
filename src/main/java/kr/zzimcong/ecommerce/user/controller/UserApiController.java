package kr.zzimcong.ecommerce.user.controller;

import kr.zzimcong.ecommerce.common.ApiResponseDto;
import kr.zzimcong.ecommerce.user.dto.UserRequestDto;
import kr.zzimcong.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static kr.zzimcong.ecommerce.common.StatusCode.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserApiController {

    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserRequestDto dto){
        userService.login(dto);
        return new ResponseEntity<>(
                new ApiResponseDto<>(SUCCESS.getCode(), SUCCESS.getMessage(), null),
                HttpStatus.OK
        );
    }
}
