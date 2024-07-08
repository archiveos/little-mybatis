package com.cracker.mybatis.datasource.pooled;

import com.cracker.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}