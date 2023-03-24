package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.dto.WtyjJgsy;
import com.gxzh.jxvueserver.entity.Cbz;
import com.gxzh.jxvueserver.entity.Ywtjg;
import com.gxzh.jxvueserver.service.WtyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/wtyj")
public class WtyjController {
    @Autowired
    private WtyjService wtyjService;


    @RequestMapping("/selectCbz")
    public Res<?> selectCbz(String depcode) {
        List<Cbz> despList = null;

        if (depcode != null) {
            despList = wtyjService.selectCbz
                    (depcode);
        }
        return Res.ok(despList);
    }


    @RequestMapping("/selectYwtjg")
    public Res<?> selectYwtjg(String depcode) {
        List<Ywtjg> despList = null;

        if (depcode != null) {
            despList = wtyjService.selectYwtjg(depcode);
        }
        return Res.ok(despList);
    }

    @RequestMapping("/getextraPieChild")
    public Res<?> getextraPieChild(String depCode,String jgsyNum){
        List<WtyjJgsy> jgsyList = null;
        if (depCode != null) {
            jgsyList = wtyjService.getextraPieChild(depCode,jgsyNum);
        }
        return Res.ok(jgsyList);
    }


}
