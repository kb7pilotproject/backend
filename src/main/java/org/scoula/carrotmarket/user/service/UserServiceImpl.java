package org.scoula.carrotmarket.user.service;

import lombok.RequiredArgsConstructor;
import org.scoula.carrotmarket.user.domain.UserVO;
import org.scoula.carrotmarket.user.dto.UserDTO;
import org.scoula.carrotmarket.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;   // 창고 담당 불러옴

    @Override
    public UserDTO login(String username, String password) {
        // 1) username으로 회원 찾기
        UserVO user = userMapper.findByUsername(username);

        // 2) 회원이 없으면 실패
        if (user == null) {
            return null;
        }

        // 3) 비번 비교 (지금은 평문 비교, 나중에 BCrypt로 교체)
        if (!user.getPassword().equals(password)) {
            return null;
        }

        // 4) 성공 → DTO로 변환해서 반환 (password 빠진 안전한 상자)
        return UserDTO.of(user);
    }
}