package com.cracker.mybatis.scripting.xmltags;

import com.cracker.mybatis.executor.parameter.ParameterHandler;
import com.cracker.mybatis.mapping.BoundSql;
import com.cracker.mybatis.mapping.MappedStatement;
import com.cracker.mybatis.mapping.SqlSource;
import com.cracker.mybatis.scripting.LanguageDriver;
import com.cracker.mybatis.scripting.defaults.DefaultParameterHandler;
import com.cracker.mybatis.scripting.defaults.RawSqlSource;
import com.cracker.mybatis.session.Configuration;
import org.dom4j.Element;

public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    /**
     * step-12 新增方法，用于处理注解配置 SQL 语句
     */
    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        // 暂时不解析动态 SQL
        return new RawSqlSource(configuration, script, parameterType);
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}