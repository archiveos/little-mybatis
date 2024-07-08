package com.cracker.mybatis.test;

import com.cracker.mybatis.io.Resources;
import com.cracker.mybatis.test.dao.IActivityDao;
import com.cracker.mybatis.test.po.Activity;
import com.alibaba.fastjson.JSON;
import com.cracker.mybatis.session.SqlSession;
import com.cracker.mybatis.session.SqlSessionFactory;
import com.cracker.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_queryActivityById() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);

        // 3. 测试验证
        Activity req = new Activity();
        req.setActivityId(100001L);

        logger.info("测试结果：{}", JSON.toJSONString(dao.queryActivityById(req)));

        // 测试时，可以分别开启对应的注释，验证功能逻辑
        // sqlSession.commit();
        // sqlSession.clearCache();
        // sqlSession.close();

        logger.info("测试结果：{}", JSON.toJSONString(dao.queryActivityById(req)));
    }

}
