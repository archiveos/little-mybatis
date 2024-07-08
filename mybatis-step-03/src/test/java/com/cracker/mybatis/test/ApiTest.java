package com.cracker.mybatis.test;


import com.cracker.mybatis.binding.MapperRegistry;
import com.cracker.mybatis.session.SqlSession;
import com.cracker.mybatis.session.SqlSessionFactory;
import com.cracker.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.cracker.mybatis.test.dao.IUserDao;
import com.cracker.mybatis.binding.MapperProxyFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.cracker.mybatis.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }


}
