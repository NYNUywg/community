package com.yang.community.dao;

import com.yang.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ywg
 * @date 2022/1/25 15:24
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
