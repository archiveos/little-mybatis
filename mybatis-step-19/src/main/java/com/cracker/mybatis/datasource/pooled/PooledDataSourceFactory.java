package com.cracker.mybatis.datasource.pooled;

import com.cracker.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
