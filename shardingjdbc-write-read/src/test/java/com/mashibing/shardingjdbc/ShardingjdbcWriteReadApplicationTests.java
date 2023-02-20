package com.mashibing.shardingjdbc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashibing.shardingjdbc.entity.Products;
import com.mashibing.shardingjdbc.mapper.ProductsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@SpringBootTest
class ShardingjdbcWriteReadApplicationTests {

    @Autowired
    private ProductsMapper productsMapper;

    @Test
    public void testInsert(){

        Products products = new Products();
        products.setPname("电视机");
        products.setPrice(2000);
        products.setFlag("1");

        productsMapper.insert(products);
    }


    //事务测试
    @Transactional
    @Test
    public void testTrans(){

        Products products = new Products();
        products.setPname("洗碗机");
        products.setPrice(1000);
        products.setFlag("1");
        productsMapper.insert(products);

        QueryWrapper<Products> wrapper = new QueryWrapper<>();
        wrapper.eq("pname","洗碗机");
        List<Products> list = productsMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }
}
