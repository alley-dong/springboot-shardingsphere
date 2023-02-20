package com.mashibing.shardingjdbc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashibing.shardingjdbc.entity.*;
import com.mashibing.shardingjdbc.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingjdbcApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Test
    public void testInsert(){

        User user = new User();
        user.setId(10086L);
        user.setUsername("大远哥");
        user.setPhone("15612344321");
        user.setPassword("123456");
        userMapper.insert(user);

        PayOrder payOrder = new PayOrder();
        payOrder.setOrder_id(12345L);
        payOrder.setProduct_name("猕猴桃");
        payOrder.setUser_id(user.getId());
        payOrder.setCount(2);
        payOrderMapper.insert(payOrder);
    }

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testInsertCourse(){

        for (int i = 0; i < 50; i++) {
            Course course = new Course();
           // course.setCid(10010L + i);
            course.setUserId(1L+i);
            course.setCname("Java面试题详解");
            course.setBrief("经典的10000道面试题");
            course.setPrice(100.00);
            course.setStatus(1);

            courseMapper.insert(course);
        }
    }

    //水平分库 --> 分库策略
    @Test
    public void testInsertCourseDB(){

        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setUserId(1L+i);
            course.setCname("Java面试题详解");
            course.setCorderNo(1000L+i);
            course.setBrief("经典的10000道面试题");
            course.setPrice(100.00);
            course.setStatus(1);

            courseMapper.insert(course);
        }
    }

    //水平分库 --> 分表策略
    @Test
    public void testInsertCourseTable(){

        for (int i = 100; i < 150; i++) {
            Course course = new Course();
            course.setUserId(1L+i);
            course.setCname("Java面试题详解");
            course.setCorderNo(1000L+i);
            course.setBrief("经典的10000道面试题");
            course.setPrice(100.00);
            course.setStatus(1);

            courseMapper.insert(course);
        }
    }

    //验证hashcode取模分片
    @Test
    public void testHashCode(){

        Long id = 797942276918607872L;

        int hash = id.hashCode();
        System.out.println(hash);

        System.out.println("=============" + Math.abs(hash % 2));
    }

    //查询所有记录
    @Test
    public void testSelectAll(){

        List<Course> courses = courseMapper.selectList(null);
        for (Course cours : courses) {
            System.out.println(cours);
        }
    }


    //根据id查询
    @Test
    public void testSelectByUserId(){

        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("user_id",2L);
        List<Course> courses = courseMapper.selectList(courseQueryWrapper);
        for (Course cours : courses) {
            System.out.println(cours);
        }
    }
    
    //测试关联表插入

    @Autowired
    private CourseSectionMapper courseSectionMapper;

    @Test
    public void testInsertCourseAndCourseSection(){

        for (int i = 0; i < 3; i++) {
            Course course = new Course();
            //userID 为分库策略的分片键
            course.setUserId(1L+i);
            course.setCname("Java面试题详解");
            course.setCorderNo(1000L+i);
            course.setBrief("经典的10000道面试题");
            course.setPrice(100.00);
            course.setStatus(1);
            courseMapper.insert(course);

            Long cid = course.getCid();
            for (int j = 0; j < 3; j++) {
                CourseSection section = new CourseSection();
                section.setCid(cid);
                section.setUserId(1L+i);
                //corderNo是分表策略的分片键
                section.setCorderNo(1000L+i);
                section.setSectionName("Java面试题详解_" + i);
                section.setStatus(1);
                courseSectionMapper.insert(section);
            }
            
        }
    }

    //关联查询
    @Test
    public void testSelectCourseNameAndSectionNum(){

        List<CourseVo> list = courseMapper.getCourseNameAndSectionNum();
        list.forEach(System.out::println);
    }

    @Autowired
    private DistrictMapper districtMapper;

    //广播表插入
    @Test
    public void testInsertBroadcast(){

        District district = new District();
        district.setDistrictName("昌平区");
        district.setLevel(1);

        districtMapper.insert(district);
    }

    @Test
    public void testSelectBroadcast(){

        List<District> districtList = districtMapper.selectList(null);
        districtList.forEach(System.out::println);
    }

}
