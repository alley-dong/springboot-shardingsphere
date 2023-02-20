package com.mashibing.shardingproxydemo;

import com.mashibing.shardingproxydemo.entity.Products;
import com.mashibing.shardingproxydemo.mapper.ProductsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingproxyDemoApplicationTests {

    @Autowired
    private ProductsMapper productsMapper;

    //测试插入
    @Test
    public void testInsert(){
        Products products = new Products();
        products.setPname("电视机");
        products.setPrice(2000);
        products.setFlag("1");

        productsMapper.insert(products);
    }

    @Test
    public void testSelect(){
        productsMapper.selectList(null).forEach(System.out::println);

    }
}
