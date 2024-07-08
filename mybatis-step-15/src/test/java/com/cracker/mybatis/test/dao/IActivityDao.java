package com.cracker.mybatis.test.dao;

import com.cracker.mybatis.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Long activityId);

    Integer insert(Activity activity);

}
