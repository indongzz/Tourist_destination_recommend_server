package com.kop.daegudot.web;

import com.kop.daegudot.service.user.UserService;
import com.kop.daegudot.web.dto.TokenResponseDto;
import com.kop.daegudot.web.dto.user.UserLoginDto;
import com.kop.daegudot.web.dto.user.UserResponseDto;
import com.kop.daegudot.web.dto.user.UserRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService mUserService;

    //Register
    @PostMapping("/user/register")
    public Long save(@RequestBody UserRegisterDto userSaveRequestDto) {
        return mUserService.save(userSaveRequestDto);
    }

    //Duplicate Check - Email
    @GetMapping("/user/register/{email}")
    public UserResponseDto findByEmail(@PathVariable String email) {
        return mUserService.findByEmail(email);
    }

    //Duplicate Check - nickname
    @GetMapping("/user/register/{nickname}")
    public UserResponseDto findByNickname(@PathVariable String nickname) {
        return mUserService.findByNickname(nickname);
    }

    //Login
    @PostMapping("user/login")
    public UserResponseDto findByEmailANDPassword(@RequestBody UserLoginDto userLoginDto) {
        return mUserService.findByEmailAndPassword(userLoginDto);
    }

    //Login test용
    @GetMapping("user/login/test/{email}/{password}")
    public ResponseEntity<TokenResponseDto> login(@PathVariable String email, @PathVariable String password){
        String token = mUserService.createToken(email, password);
        return ResponseEntity.ok().body(new TokenResponseDto(token, "bearer"));
    }
}
