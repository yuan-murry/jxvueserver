package com.gxzh.jxvueserver.config;

public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    //设置当前线程持有的数据源
    public static synchronized void setDBType(String dbType) {
        contextHolder.set(dbType);
    }

    //获取当前线程持有的数据源
    public static String getDBType() {
        return contextHolder.get();
    }

    public static void clearDBType() {
        contextHolder.remove();
    }
}


