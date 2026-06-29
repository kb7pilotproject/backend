package org.scoula.carrotmarket.user.service;

import org.scoula.carrotmarket.user.dto.UserDTO;

public interface UserService {
    // 로그인: 성공하면 회원정보(DTO) 반환, 실패하면 null
    UserDTO login(String username, String password);
}
