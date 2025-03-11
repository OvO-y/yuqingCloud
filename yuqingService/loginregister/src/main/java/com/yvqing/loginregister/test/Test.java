package com.yvqing.loginregister.test;

import com.yuqing.user.bean.User;
import com.yvqing.loginregister.dao.LoReDao;
import com.yvqing.loginregister.dto.LoReDto;
import com.yvqing.loginregister.dto.UserRegistrationDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Test class.
 *
 * @author Administrator
 * @since 2025/1/10
 */
public class Test {



    private static SqlSessionFactory sqlSessionFactory;

    static {
        try (InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception appropriately, for example by throwing a RuntimeException or exiting the application
            System.exit(1);
        }
    }

    public static void test() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LoReDao mapper = sqlSession.getMapper(LoReDao.class);
            List<User> studentList = mapper.findALL();
            studentList.forEach(System.out::println);
        }
    }
    public static void test01() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LoReDao mapper = sqlSession.getMapper(LoReDao.class);
//            User user= mapper.getUserByAccount(123456).get(0);
//            User user= mapper.getUserByPhone("19979738705");
            User user= mapper.getUserByEmail("123456@qq.com").get(0);
            int re= mapper.findUserByPhone("19979710");
            if (mapper.findUserByPhone("199798710") == 0 ){
                System.out.println("test failed");
            }else {
                System.out.println("test successfully");
            }
            System.out.println("test:"+re);
            System.out.println(user);
        }
    }

    public static void register() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LoReDao mapper = sqlSession.getMapper(LoReDao.class);
            User user = new User();
            user.setAccount("1234567890");
            user.setTelephone("1234567890");
            user.setPassword("123456");
            mapper.addUserByPhone(user);
           int user1 = mapper.findUserByPhone("1234567890");
           System.out.println("user1:" + user1);
           User user2 = mapper.getUserByAccount("1234567890").get(0);
           System.out.println("user2:" + user2);
        }
    }
    public static void main(String[] args) {
        register();
        test();
//        test01();
    }
}
