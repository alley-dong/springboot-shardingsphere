package com.mashibing.shardingproxydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashibing.shardingproxydemo.entity.Products;
import org.springframework.stereotype.Repository;

/**
 * @author spikeCong
 * @date 2022/11/24
 **/
@Repository
public interface ProductsMapper extends BaseMapper<Products> {
}
