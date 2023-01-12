package com.gxzh.jxvueserver.config;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author ZhiPengyu
 * @ClassName: [DruidDataSourceUtil.java]
 * @Description: [用于查找并切换数据源]
 */
public class DruidDataSourceUtil {
    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceUtil.class);

    public static void addOrChangeDataSource(String key, String dbip, String dbname, String dbuser, String dbpwd) {
        DataSourceContextHolder.setDBType("default");

        /**
         * 创建动态数据源
         */
        Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();
        if (!dataSourceMap.containsKey(key + "master") && null != key) {
            logger.info("插入新数据库连接信息为：" + dbname);
            DruidDataSource dynamicDataSource = new DruidDataSource();
            dynamicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");

            dynamicDataSource.setUsername(dbuser);
            dynamicDataSource.setUrl("jdbc:oracle:thin:@" + dbip + ":1521:smz");
            dynamicDataSource.setPassword(dbpwd);

            dynamicDataSource.setInitialSize(50);
            dynamicDataSource.setMinIdle(5);
            dynamicDataSource.setMaxActive(1000);
            dynamicDataSource.setMaxWait(5000);
            dynamicDataSource.setTimeBetweenEvictionRunsMillis(60000);
            dynamicDataSource.setMinEvictableIdleTimeMillis(300000);
            dynamicDataSource.setValidationQuery("SELECT 1 FROM DUAL");
            dynamicDataSource.setTestWhileIdle(true);
            dynamicDataSource.setTestOnBorrow(false);
            dynamicDataSource.setTestOnReturn(false);
            dynamicDataSource.setPoolPreparedStatements(true);
            dynamicDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

            dynamicDataSource.setRemoveAbandoned(true);
            dynamicDataSource.setRemoveAbandonedTimeout(180);
            dynamicDataSource.setLogAbandoned(true);

            dataSourceMap.put(key + "master", dynamicDataSource);
            DynamicDataSource.getInstance().setTargetDataSources(dataSourceMap);
            //切换为动态数据源实例
            DataSourceContextHolder.setDBType(key + "master");
        } else {
            //切换为动态数据源实例
            DataSourceContextHolder.setDBType(key + "master");
        }
    }

}


