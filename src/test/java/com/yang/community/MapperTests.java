package com.yang.community;



import com.yang.community.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
/**
 * @author ywg
 * @date 2022/1/25 15:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void  testSelectUser(){
        System.out.println(userMapper.selectById(1));
        System.out.println(userMapper.selectByName("张三"));
        System.out.println(userMapper.selectByEmail("nowcoder11@sina.com"));

    }
}

