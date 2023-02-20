package com.mashibing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author spikeCong
 * @date 2022/11/18
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Insert("INSERT INTO t_user(user_id,user_name,password)\n" +
            "VALUES(#{userId},#{userName},#{password})")
    void insertUser(User user);



    @Select("select * from t_user where user_name=#{userName} and password=#{password}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "password", property = "password"),
            @Result(column = "password_assisted", property = "passwordAssisted")
    })
    List<User> getUserInfo(String userName,String password);

}
