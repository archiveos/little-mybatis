package com.cracker.mybatis.session;

public interface SqlSessionFactory {

    /**
     * 打开一个 session
     *
     * @return SqlSession
     */
    SqlSession openSession();

}
