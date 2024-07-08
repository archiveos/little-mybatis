package com.cracker.middleware.test.dao;

import com.cracker.middleware.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
