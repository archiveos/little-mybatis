package com.cracker.mybatis.scripting;

import com.cracker.mybatis.mapping.SqlSource;
import com.cracker.mybatis.session.Configuration;
import org.dom4j.Element;

public interface LanguageDriver {

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}
