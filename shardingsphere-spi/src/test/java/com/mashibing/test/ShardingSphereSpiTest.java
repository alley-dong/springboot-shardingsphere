package com.mashibing.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashibing.entity.Course;
import com.mashibing.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author spikeCong
 * @date 2022/11/25
 **/
@SpringBootTest
public class ShardingSphereSpiTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testInsertCourseTable(){

        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setUserId(100L+i);
            course.setCname("Java面试题详解");
            course.setCorderNo(200L+i);
            course.setBrief("经典的10000道面试题");
            course.setPrice(100.00);
            course.setStatus(1);

            courseMapper.insert(course);
        }
    }


    @Test
    public  void getCourseByUserId(){

        //指定分库字段进行查询
//        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
//
//        queryWrapper.eq("user_id",100L);
//        courseMapper.selectList(queryWrapper).forEach(System.out::print);


        //根据分表字段查询
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("cid",804807819248271361L);
        courseMapper.selectList(queryWrapper).forEach(System.out::print);
    }

    //范围查询
    @Test
    public void getCourseBetween(){

        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();

        queryWrapper.between("cid",804807819248271361L,804807819713839105L);

        courseMapper.selectList(queryWrapper).forEach(System.out::print);
    }


}
