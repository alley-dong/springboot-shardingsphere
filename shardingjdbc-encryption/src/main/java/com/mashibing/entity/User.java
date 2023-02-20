package com.mashibing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author spikeCong
 * @date 2022/11/18
 **/
@TableName("t_user")
@Data
public class User {

    @TableId(value = "user_id",type = IdType.ASSIGN_ID)
    private Long userId;

    private String userName;

    private String password;

    private String passwordEncrypt;

    private String passwordAssisted;
}
