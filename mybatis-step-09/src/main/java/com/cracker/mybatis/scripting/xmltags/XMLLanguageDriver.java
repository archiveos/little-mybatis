package com.cracker.mybatis.scripting.xmltags;

import com.cracker.mybatis.mapping.SqlSource;
import com.cracker.mybatis.scripting.LanguageDriver;
import com.cracker.mybatis.session.Configuration;
import org.dom4j.Element;

public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

}