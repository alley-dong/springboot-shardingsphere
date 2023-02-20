package com.mashibing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author spikeCong
 * @date 2022/11/15
 **/
@TableName("t_course")
@Data
@ToString
public class Course {

    @TableId(type = IdType.ASSIGN_ID)
    private Long cid;

    private Long userId;

    private Long corderNo;

    private String cname;

    private String brief;

    private double price;

    private int status;
}
