package com.cracker.mybatis.executor;


import com.cracker.mybatis.mapping.BoundSql;
import com.cracker.mybatis.mapping.MappedStatement;
import com.cracker.mybatis.session.ResultHandler;
import com.cracker.mybatis.session.RowBounds;
import com.cracker.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    int update(MappedStatement ms, Object parameter) throws SQLException;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}