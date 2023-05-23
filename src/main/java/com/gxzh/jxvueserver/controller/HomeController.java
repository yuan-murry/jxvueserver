package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.*;
import com.gxzh.jxvueserver.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping("/sydwpie")
    public Res<?> selectSydwpie(@RequestParam("depCode") String depCode) {
        SydwPie sydwPie = this.homeService.selectSydwpie(depCode);
        return Res.ok(sydwPie);
    }

    @RequestMapping("/xzjgpie")
    public Res<?> selectXzjgpie(@RequestParam("depCode") String depCode) {
        XzjgPie xzjgPie = this.homeService.selectXzjgpie(depCode);
        return Res.ok(xzjgPie);
    }

    @RequestMapping("/bzqk")
    public Res<?> selectBzqk(@RequestParam("depCode") String depCode) {
        Bzqk bzqk = this.homeService.selectBzqk(depCode);
        return Res.ok(bzqk);
    }

    @RequestMapping("/xzldzs")
    public Res<?> selectxzldzs(@RequestParam("depCode") String depCode) {
        Ldzs ldzs = this.homeService.selectXzLdzs(depCode);
        return Res.ok(ldzs);
    }

    @RequestMapping("/syldzs")
    public Res<?> selectSyldzs(@RequestParam("depCode") String depCode) {
        Ldzs ldzs = this.homeService.selectSyLdzs(depCode);
        return Res.ok(ldzs);
    }

    @RequestMapping("/getGeoSituation")
    public Res<?> getGeoSituation(@RequestParam("depCode") String depCode) {
        GeoSituation geoSituation = this.homeService.getGeoSituation(depCode);
        return Res.ok(geoSituation);
    }


    @RequestMapping("/selectXzjgLdzsChild")
    public Res<?> selectXzjgLdzsChild(@RequestParam("depCode") String depCode,@RequestParam("ldzstype") String ldzstype) {
        List<XzjgLdzsChild> xzjgLdzsChildList = this.homeService.selectXzjgLdzsChild(depCode,ldzstype);
        return Res.ok(xzjgLdzsChildList);
    }


    @RequestMapping("/selectSyjgLdzsChild")
    public Res<?> selectSyjgLdzsChild(@RequestParam("depCode") String depCode,@RequestParam("ldzstype") String ldzstype) {
        List<SyjgLdzsChild> syjgLdzsChildList = this.homeService.selectSyjgLdzsChild(depCode,ldzstype);
        return Res.ok(syjgLdzsChildList);
    }

    @RequestMapping("/selectXzjgPieChild")
    public Res<?> selectXzjgPieChild(@RequestParam("depCode") String depCode,@RequestParam("depName") String depName) {
        List<XzjgPieChild> xzjgPieChildList = this.homeService.selectXzjgPieChild(depCode,depName);
        return Res.ok(xzjgPieChildList);
    }

    @RequestMapping("/selectSydwPieChild")
    public Res<?> selectSydwPieChild(@RequestParam("depCode") String depCode,@RequestParam("depName") String depName) {
        List<SydwPieChild> sydwPieChildList = this.homeService.selectSydwPieChild(depCode,depName);
        return Res.ok(sydwPieChildList);
    }


    @RequestMapping("/selectXzjgLdzsChildDetail")
    public Res<?> selectXzjgLdzsChildDetail(@RequestParam("depCode") String depCode,@RequestParam("doquery") String doquery) {
        List<XzjgLdzsChildDetail> xzjgLdzsChildDetailList = this.homeService.selectXzjgLdzsChildDetail(depCode,doquery);
        return Res.ok(xzjgLdzsChildDetailList);
    }

    @RequestMapping("/selectSydwLdzsChildDetail")
    public Res<?> selectSydwLdzsChildDetail(@RequestParam("depCode") String depCode,@RequestParam("doquery") String doquery) {
        List<SydwLdzsChildDetail> sydwLdzsChildDetailList = this.homeService.selectSydwLdzsChildDetail(depCode,doquery);
        return Res.ok(sydwLdzsChildDetailList);
    }

}
