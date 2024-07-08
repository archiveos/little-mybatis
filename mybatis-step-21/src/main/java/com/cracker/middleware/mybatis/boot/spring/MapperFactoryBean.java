package com.cracker.middleware.mybatis.boot.spring;

import com.cracker.mybatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;

import javax.annotation.Resource;

public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        return sqlSessionFactory.openSession().getMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}