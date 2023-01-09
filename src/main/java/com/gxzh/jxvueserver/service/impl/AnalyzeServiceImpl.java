package com.gxzh.jxvueserver.service.impl;

import com.gxzh.jxvueserver.entity.*;
import com.gxzh.jxvueserver.mapper.AnalyzeMapper;
import com.gxzh.jxvueserver.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyzeServiceImpl implements AnalyzeService {
@Autowired
private AnalyzeMapper analyzeMapper;
    
    public List<Ywlx> selectYwlx(String depcode){
        String code ="360000";
        List<Ywlx> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= analyzeMapper.selectYwlx(depcode,code);

        return despList;
    }


    public List<Nywbl> selectNywbl(String depcode){
        String code ="360000";
        List<Nywbl> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= analyzeMapper.selectNywbl(depcode,code);

        return despList;
    }

    public List<Yywbl> selectYywbl(String depcode){
        String code ="360000";
        List<Yywbl> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= analyzeMapper.selectYywbl(depcode,code);

        return despList;
    }

    public List<Gdyw> selectGdyw(String depcode){
        String code ="360000";
        List<Gdyw> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= analyzeMapper.selectGdyw(depcode,code);

        return despList;
    }

    public List<Jryw> selectJryw(String depcode){
        String code ="360000";
        List<Jryw> despList=null;
        if(depcode!=null && depcode.indexOf("__")!=-1){

        }else{
            code=depcode.replace("%","00");
        }
        despList= analyzeMapper.selectJryw(depcode,code);

        return despList;
    }
}
