package org.scoula.carrotmarket.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
    private int userId;
    private String username;
    private String password;
    private String email;
}

