package org.scoula.carrotmarket.user.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.carrotmarket.user.domain.UserVO;

public interface UserMapper {
    @Select("SELECT user_id as userId, username, password, email " +
            "FROM user WHERE username = #{username}")
    UserVO findByUsername(String username);

}
