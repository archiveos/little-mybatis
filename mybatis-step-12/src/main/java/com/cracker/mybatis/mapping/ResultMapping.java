package com.cracker.mybatis.mapping;

import com.cracker.mybatis.session.Configuration;
import com.cracker.mybatis.type.JdbcType;
import com.cracker.mybatis.type.TypeHandler;

public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}
