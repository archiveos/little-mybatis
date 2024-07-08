package com.cracker.mybatis.test;


import com.cracker.mybatis.binding.MapperRegistry;
import com.cracker.mybatis.io.Resources;
import com.cracker.mybatis.session.SqlSession;
import com.cracker.mybatis.session.SqlSessionFactory;
import com.cracker.mybatis.session.SqlSessionFactoryBuilder;
import com.cracker.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.cracker.mybatis.test.dao.IUserDao;
import com.cracker.mybatis.binding.MapperProxyFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }

}