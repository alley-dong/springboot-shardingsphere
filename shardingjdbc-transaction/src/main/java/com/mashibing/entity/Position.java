package com.mashibing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author spikeCong
 * @date 2022/11/22
 **/
@TableName("position")
@Data
public class Position {

    @TableId(type = IdType.AUTO)
    private long id;

    private String name;

    private String salary;

    private String city;
}
