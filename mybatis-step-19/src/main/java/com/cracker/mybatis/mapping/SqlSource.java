package com.cracker.mybatis.mapping;

public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
