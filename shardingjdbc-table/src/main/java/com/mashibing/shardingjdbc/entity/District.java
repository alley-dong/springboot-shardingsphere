package com.mashibing.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 地理区域表-公共表
 * @author spikeCong
 * @date 2022/11/15
 **/
@TableName("t_district")
@Data
public class District {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String districtName;

    private int level;
}
