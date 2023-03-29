package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.dto.WtyjJgsy;
import com.gxzh.jxvueserver.entity.*;
import com.gxzh.jxvueserver.service.WtyjService;
import org.springframework.beans.factory.annotation.Autowired;
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




    @RequestMapping("/selectAzwtlx")
    public Res<?> selectAzwtlx(String depcode) {
        List<Azwtlx> despList = null;

        if (depcode != null) {
            despList = wtyjService.selectAzwtlx(depcode);
        }
        return Res.ok(despList);
    }

    @RequestMapping("/selectAzzgfs")
    public Res<?> selectAzzgfs(String depcode) {
        List<Azzgfs> despList = null;

        if (depcode != null) {
            despList = wtyjService.selectAzzgfs(depcode);
        }
        return Res.ok(despList);
    }

    @RequestMapping("/selectYwttz")
    public Res<?> selectYwttz(String depcode) {
        List<Ywttz> despList = null;

        if (depcode != null) {
            despList = wtyjService.selectYwttz(depcode);
        }
        return Res.ok(despList);
    }

}
