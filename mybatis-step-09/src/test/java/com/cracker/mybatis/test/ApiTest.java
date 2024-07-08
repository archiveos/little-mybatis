package com.cracker.mybatis.test;


import com.alibaba.fastjson.JSON;
import com.cracker.mybatis.binding.MapperRegistry;
import com.cracker.mybatis.builder.xml.XMLConfigBuilder;
import com.cracker.mybatis.datasource.pooled.PooledDataSource;
import com.cracker.mybatis.io.Resources;
import com.cracker.mybatis.session.Configuration;
import com.cracker.mybatis.session.SqlSession;
import com.cracker.mybatis.session.SqlSessionFactory;
import com.cracker.mybatis.session.SqlSessionFactoryBuilder;
import com.cracker.mybatis.session.defaults.DefaultSqlSession;
import com.cracker.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.cracker.mybatis.test.dao.IUserDao;
import com.cracker.mybatis.binding.MapperProxyFactory;
import com.cracker.mybatis.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

}
