package com.mashibing.testEncryption;

import com.mashibing.ShardingSphereApplication;
import com.mashibing.entity.User;
import com.mashibing.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author spikeCong
 * @date 2022/11/18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereApplication.class)
public class TestShardingEncryption {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser(){

        User user = new User();
        user.setUserName("user2022");
        user.setPassword("123456");

        userMapper.insertUser(user);
    }


    @Test
    public void testSelect(){
        List<User> userList = userMapper.getUserInfo("user2022", "123456");
        userList.forEach(System.out::println);
    }
}
