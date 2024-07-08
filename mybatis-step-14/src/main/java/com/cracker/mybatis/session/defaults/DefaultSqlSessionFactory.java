package com.cracker.mybatis.session.defaults;

import com.cracker.mybatis.binding.MapperRegistry;
import com.cracker.mybatis.executor.Executor;
import com.cracker.mybatis.mapping.Environment;
import com.cracker.mybatis.session.Configuration;
import com.cracker.mybatis.session.SqlSession;
import com.cracker.mybatis.session.SqlSessionFactory;
import com.cracker.mybatis.session.TransactionIsolationLevel;
import com.cracker.mybatis.transaction.Transaction;
import com.cracker.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }

}
