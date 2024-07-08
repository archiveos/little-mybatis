package com.cracker.middleware.mybatis.spring.test.dao;

import com.cracker.middleware.mybatis.spring.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Activity activity);

}
