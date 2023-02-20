package com.mashibing.testhint;

import com.mashibing.ShardingSphereApplication;
import com.mashibing.entity.Course;
import com.mashibing.entity.Products;
import com.mashibing.mapper.CourseMapper;
import com.mashibing.mapper.ProductsMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author spikeCong
 * @date 2022/11/15
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereApplication.class)
public class TestHint {

    @Autowired
    private CourseMapper courseMapper;

    //测试强制路由 到指定库的插入操作
    @Test
    public void testInsertCourse(){

        //通过hintManager 指定执行策略的分片键的值
        HintManager hintManager = HintManager.getInstance();

        //强制路由到 db$->{1%2}  = db1
        hintManager.setDatabaseShardingValue(1L);

        for (int i = 0; i < 5; i++) {
            Course course = new Course();
            course.setUserId(1001L+i);
            course.setCname("Java经典面试题讲解");
            course.setBrief("课程涵盖目前最容易被问到的10000道Java面试题");
            course.setPrice(100.0);
            course.setStatus(1);
            courseMapper.insert(course);
        }

    }

    //强制路由到库
    @Test
    public void testSelect(){
        HintManager hintManager = HintManager.getInstance();

        hintManager.setDatabaseShardingValue(0L);

        List<Course> courses = courseMapper.selectList(null);
        System.out.println(courses);
    }

    //强制路由到库到表
    @Test
    public void testHintDbToTable(){

        HintManager hintManager = HintManager.getInstance();

        //强制路由到指定库
        hintManager.addDatabaseShardingValue("t_course",1L);  //-->db1

        //强制路由到指定表
        hintManager.addTableShardingValue("t_course",0L);  //-->t_course_1

        List<Course> courses = courseMapper.selectList(null);
        courses.forEach(System.out::println);
    }

    @Autowired
    private ProductsMapper productsMapper;

    //强制路由走主库查询
    @Test
    public void testHintToMaster(){

        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();  //设置强制走主库

        List<Products> products = productsMapper.selectList(null);
        products.forEach(System.out::println);
    }

}
