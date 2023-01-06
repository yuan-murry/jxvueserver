package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.mapper.HomeMapper;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public String selectJgsyName() {
        return homeMapper.selectJgsyName();
    }
}
