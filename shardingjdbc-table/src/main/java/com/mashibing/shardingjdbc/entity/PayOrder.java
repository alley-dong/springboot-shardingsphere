package com.mashibing.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author spikeCong
 * @date 2022/11/8
 **/
@TableName("pay_order")
@Data
@ToString
public class PayOrder {


    @TableId
    private Long order_id;

    private long user_id;

    private String product_name;

    private int count;

}
