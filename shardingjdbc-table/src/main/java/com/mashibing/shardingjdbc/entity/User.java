package com.mashibing.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author spikeCong
 * @date 2022/11/8
 **/
@TableName("users")
@Data
@ToString
public class User {

    @TableId
    private long id;

    private String username;

    private String phone;

    private String password;
}
