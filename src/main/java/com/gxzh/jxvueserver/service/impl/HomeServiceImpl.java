package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.dto.Bzqk;
import com.gxzh.jxvueserver.dto.Ldzs;
import com.gxzh.jxvueserver.dto.SydwPie;
import com.gxzh.jxvueserver.dto.XzjgPie;
import com.gxzh.jxvueserver.mapper.HomeMapper;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public SydwPie selectSydwpie(String depCode) {
        SydwPie sydwPie = homeMapper.selectSydwpie(depCode);
        if(sydwPie==null){
            return new SydwPie();
        }
        return sydwPie;
    }

    @Override
    public XzjgPie selectXzjgpie(String depCode) {
        XzjgPie xzjgPie = homeMapper.selectXzjgpie(depCode);
        if(xzjgPie==null){
            return new XzjgPie();
        }
        return xzjgPie;
    }

    @Override
    public Bzqk selectBzqk(String depCode) {
        Bzqk bzqk = homeMapper.selectBzqk(depCode);
        if(bzqk==null){
            return new Bzqk();
        }
        return bzqk;
    }

    @Override
    public Ldzs selectXzLdzs(String depCode) {
        Ldzs ldzs = homeMapper.selectXzLdzs(depCode);
        if(ldzs==null){
            return new Ldzs();
        }
        return ldzs;
    }

    @Override
    public Ldzs selectSyLdzs(String depCode) {
        Ldzs ldzs = homeMapper.selectSyLdzs(depCode);
        if(ldzs==null){
            return new Ldzs();
        }
        return ldzs;
    }
}
