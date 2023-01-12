package com.gxzh.jxvueserver.config;

import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String requestUrl = request.getRequestURI();
        logger.info("["+requestUrl+"]请求地址校验!");
        Object o = redisTemplate.opsForValue().get("jxvue:database");
        String databaseName = "";
        if(o!=null){
            databaseName = (String) o;
        }
        //判断URL是否需要验证
        if("zbbsmzv50".equals(databaseName)){
            DruidDataSourceUtil.addOrChangeDataSource("","192.168.100.150","zbbsmzv50","zbbsmzv50","smzSmz123");
        }
            chain.doFilter(request, response);
            return;
    }

}


