package com.itheima.mapper;

import com.qcm.mapper.UserMapper;
import com.qcm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 从classpath目录加载全局配置文件,以流的形式返回
            InputStream reader = Resources.getResourceAsStream("SqlMapConfig.xml");

            // 创建SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 获取sqlSessionFactory
            sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.err.println(mapper);
        User user = mapper.findById(1);

        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void findByName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findByName("张");
        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();

        user.setUsername("ooooooooo");
        user.setSex("");
        user.setBirthday(new Date());
        user.setAddress("");

        mapper.insertUser(user);

        sqlSession.commit();
        sqlSession.close();
    }
}