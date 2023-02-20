package com.mashibing.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.shardingjdbc.entity.Products;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author spikeCong
 * @date 2022/11/15
 **/
@Mapper
public interface ProductsMapper extends BaseMapper<Products> {

}
