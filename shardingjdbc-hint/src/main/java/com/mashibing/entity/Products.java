package com.mashibing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author spikeCong
 * @date 2022/11/18
 **/
@TableName("products")
@Data
public class Products {

    @TableId(value = "pid",type = IdType.AUTO)
    private Long pid;

    private String pname;

    private int  price;

    private String flag;
}
