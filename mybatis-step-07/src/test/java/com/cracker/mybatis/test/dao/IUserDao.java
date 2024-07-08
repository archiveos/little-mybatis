package com.cracker.mybatis.test.dao;

import com.cracker.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
