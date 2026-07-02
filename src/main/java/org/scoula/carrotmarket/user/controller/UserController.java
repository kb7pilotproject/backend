package org.scoula.carrotmarket.user.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.carrotmarket.user.dto.UserDTO;
import org.scoula.carrotmarket.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO loginRequest,
                                   HttpSession session) {
        UserDTO user = userService.login(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );

        if (user == null) {
            // 실패: 401 + 메시지
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("아이디 또는 비밀번호가 틀렸습니다.");
        }

        // 성공: 세션에 로그인 정보 저장 (입장 도장)
        session.setAttribute("loginUser", user);
        return ResponseEntity.ok(user);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();   // 도장 지우기
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }
}