package com.gxzh.jxvueserver.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.type}")
    private String db_type;

    @Value("${spring.datasource.driver-class-name}")
    private String db_driver_name;

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String db_user;

    @Value("${spring.datasource.password}")
    private String db_pwd;

    // 连接池初始化大小
    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    // 连接池最小值
    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    // 连接池最大 值
    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    // 配置获取连接等待超时的时间
    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    // 配置一个连接在池中最小生存的时间，单位是毫秒
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    // 用来验证数据库连接的查询语句,这个查询语句必须是至少返回一条数据的SELECT语句
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    // 检测连接是否有效
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    // 申请连接时执行validationQuery检测连接是否有效。做了这个配置会降低性能。
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    // 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    // 是否缓存preparedStatement，也就是PSCache。
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    // 指定每个连接上PSCache的大小。
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    // 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    @Value("${spring.datasource.filters}")
    private String filters;

    // 通过connectProperties属性来打开mergeSql功能；慢SQL记录
    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;

    // Druid控制台配置：记录慢SQL
//    @Value("${spring.datasource.logSlowSql}")
//    private String logSlowSql;
//
//    @Value("${spring.datasource.removeAbandoned}")
//    private boolean removeAbandoned;
//
//    @Value("${spring.datasource.removeAbandonedTimeout}")
//    private int removeAbandonedTimeout;
//
//    @Value("${spring.datasource.logAbandoned}")
//    private boolean logAbandoned;

    @Bean
    public DynamicDataSource druidDataSource() {
        Map<Object,Object> map = new HashMap<>();
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        DruidDataSource defaultDataSource = new DruidDataSource();

        defaultDataSource.setDriverClassName(db_driver_name);
        defaultDataSource.setUrl(db_url);
        defaultDataSource.setUsername(db_user);
        defaultDataSource.setPassword(db_pwd);
        defaultDataSource.setInitialSize(initialSize);
        defaultDataSource.setMinIdle(minIdle);
        defaultDataSource.setMaxActive(maxActive);
        defaultDataSource.setMaxWait(maxWait);
        defaultDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        defaultDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        defaultDataSource.setValidationQuery(validationQuery);
        defaultDataSource.setTestWhileIdle(testWhileIdle);
        defaultDataSource.setTestOnBorrow(testOnBorrow);
        defaultDataSource.setTestOnReturn(testOnReturn);
        defaultDataSource.setPoolPreparedStatements(poolPreparedStatements);
        defaultDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        defaultDataSource.setRemoveAbandoned(removeAbandoned);
//        defaultDataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
//        defaultDataSource.setLogAbandoned(logAbandoned);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

        map.put("default", defaultDataSource);
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);


        return dynamicDataSource;
    }

    @Bean
    public ServletRegistrationBean<Servlet>  druid(){
        // 现在要进行druid监控的配置处理操作
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 白名单,多个用逗号分割， 如果allow没有配置或者为空，则允许所有访问
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 黑名单,多个用逗号分割 (共同存在时，deny优先于allow)
        //servletRegistrationBean.addInitParameter("deny", "192.168.1.110");
        // 控制台管理用户名
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        // 控制台管理密码
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        // 是否可以重置数据源，禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>() ;
        filterRegistrationBean.setFilter(new WebStatFilter());
        //所有请求进行监控处理
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return filterRegistrationBean ;
    }

}


