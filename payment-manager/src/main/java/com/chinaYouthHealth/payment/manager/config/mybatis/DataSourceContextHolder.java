package com.chinaYouthHealth.payment.manager.config.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZhenWeiLai on 2016/11/22.
 */
public class DataSourceContextHolder {
	private static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> dataSourceLocal = new ThreadLocal<>();

    public static ThreadLocal<String> getDataSourceLocal() {
        return dataSourceLocal;
    }

    /**
     * 从库 可以有多个
     */
    public static void read() {
        dataSourceLocal.set(TargetDataSource.READ.getCode());
    }

    /**
     * 主库 只有一个
     */
    public static void write() {
        dataSourceLocal.set(TargetDataSource.WRITE.getCode());
    }

    public static String getTargetDataSource() {
    	String dataSource =dataSourceLocal.get();
    	log.info("dataSource===========:"+dataSource);
        return dataSource;
    }

}
