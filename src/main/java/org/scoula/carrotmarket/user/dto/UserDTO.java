package org.scoula.carrotmarket.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.carrotmarket.user.domain.UserVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private int userId;
    private String username;
    private String password;
    private String email;

    // dto -> vo
    public UserVO toVo() {
        return UserVO.builder()
                .userId(userId)
                .username(username)
                .password(password)
                .email(email)
                .build();
    }

    // vo -> dto
    public static UserDTO of(UserVO vo) {
        return vo == null ? null : UserDTO.builder()
                .userId(vo.getUserId())
                .username(vo.getUsername())
                .email(vo.getEmail())
                .build();
    }
}
