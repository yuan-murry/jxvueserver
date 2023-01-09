package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.service.BzzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bzzy")
public class BzzyController {
    @Autowired
    private BzzyService bzzyService;

    @RequestMapping("/xzbzpie")
    public Res<?> getXzbzpie(@RequestParam("depCode") String depCode){
        List<Gdbz> xzbzpie = this.bzzyService.getXzbzpie(depCode);
        return Res.ok(xzbzpie);
    }

    @RequestMapping("/ldzspie")
    public Res<?> getLdzspie(@RequestParam("depCode") String depCode){
        List<BzzyLdzs> ldzspie = this.bzzyService.getLdzspie(depCode);
        return Res.ok(ldzspie);
    }

    @RequestMapping("/bzlx")
    public Res<?> getBzzyBzlx(@RequestParam("depCode") String depCode){
        BzzyBzlx bzzyBzlx = this.bzzyService.getBzzyBzlx(depCode);
        return Res.ok(bzzyBzlx);
    }

    @RequestMapping("/nouse")
    public Res<?> getNoUse(@RequestParam("depCode") String depCode){
        List<BzzyNoUse> noUse = this.bzzyService.getNoUse(depCode);
        return Res.ok(noUse);
    }

    @RequestMapping("/retire")
    public Res<?> getRetire(@RequestParam("depCode") String depCode){
        BzzyRetire retire = this.bzzyService.getRetire(depCode);
        return Res.ok(retire);
    }

    @RequestMapping("/industry")
    public Res<?> getInsdstry(@RequestParam("depCode") String depCode){
        List<BzzyIndstry> insdstry = this.bzzyService.getInsdstry(depCode);
        return Res.ok(insdstry);
    }

}
