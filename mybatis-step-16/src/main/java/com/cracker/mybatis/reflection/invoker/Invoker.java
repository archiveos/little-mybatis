package com.cracker.mybatis.reflection.invoker;

public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
