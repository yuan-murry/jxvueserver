package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.AreaBusinessChild;
import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.entity.*;
import com.gxzh.jxvueserver.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/analyze")
public class AnalyzeController {
    @Autowired
    private AnalyzeService analyzeService;

    @RequestMapping("/selectYwlx")
    public Res<?> selectYwlx(String depcode) {
        List<Ywlx> despList = null;

        if (depcode != null) {
            despList = analyzeService.selectYwlx
                    (depcode);

        }


        return Res.ok(despList);
    }


    @RequestMapping("/selectNywbl")
    public Res<?> selectNywbl(String depcode) {
        List<Nywbl> despList = null;

        if (depcode != null) {
            despList = analyzeService.selectNywbl
                    (depcode);

        }


        return Res.ok(despList);
    }

    @RequestMapping("/selectYywbl")
    public Res<?> selectYywbl(String depcode) {
        List<Yywbl> despList = null;

        if (depcode != null) {
            despList = analyzeService.selectYywbl
                    (depcode);

        }


        return Res.ok(despList);
    }

    @RequestMapping("/selectGdyw")
    public Res<?> selectGdyw(String depcode) {
        List<Gdyw> despList = null;
        if (depcode != null) {
            despList = analyzeService.selectGdyw(depcode);
        }
        return Res.ok(despList);
    }


    @RequestMapping("/selectJryw")
    public Res<?> selectJryw(String depcode) {
        List<Jryw> despList = null;
        if (depcode != null) {
            despList = analyzeService.selectJryw(depcode);
        }
        return Res.ok(despList);
    }

    @RequestMapping("/getAreaBusinessChild")
    public Res<?> getAreaBusinessChild(String depName) {
        AreaBusinessChild areaBusinessChild = analyzeService.getAreaBusinessChild(depName);
        return Res.ok(areaBusinessChild);
    }

}
