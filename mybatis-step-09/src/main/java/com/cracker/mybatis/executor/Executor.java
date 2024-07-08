package com.cracker.mybatis.executor;


import com.cracker.mybatis.mapping.BoundSql;
import com.cracker.mybatis.mapping.MappedStatement;
import com.cracker.mybatis.transaction.Transaction;
import sun.plugin2.main.server.ResultHandler;

import java.sql.SQLException;
import java.util.List;

public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}