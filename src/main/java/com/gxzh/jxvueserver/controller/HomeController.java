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


    @RequestMapping("/bzqk_fc")
    public Res<?> selectBzqk(@RequestParam("depCode") String depCode,@RequestParam("type") String type) {


        List<Bzqk_fc>   bzqk_fc=  this.homeService.selectBzqk_fc(depCode,type);


        return Res.ok(bzqk_fc);
    }

    @RequestMapping("/bzqk_fc_sy")
    public Res<?> selectBzqk_sy(@RequestParam("depCode") String depCode,@RequestParam("type") String type) {


        List<Bzqk_fc_sy>   bzqk_fc_sy=  this.homeService.selectBzqk_sy(depCode,type);


        return Res.ok(bzqk_fc_sy);
    }



    @RequestMapping("/getXzjgBzsChildDfp")
    public Res<?> getXzjgBzsChildDfp(@RequestParam("depCode") String depCode) {


        List<XzjgBzsChildDfp>   xzjgBzsChildDfpList=  this.homeService.getXzjgBzsChildDfp(depCode);


        return Res.ok(xzjgBzsChildDfpList);
    }

    @RequestMapping("/getSydwBzsChildDfp")
    public Res<?> getSydwBzsChildDfp(@RequestParam("depCode") String depCode) {


        List<SydwBzsChildDfp>   sydwBzsChildDfpList=  this.homeService.getSydwBzsChildDfp(depCode);


        return Res.ok(sydwBzsChildDfpList);
    }


    @RequestMapping("/selectDzq_fc")
    public Res<?> selectDzq_fc(@RequestParam("depCode") String depCode,@RequestParam("type") String type) {


        List<Dzq_fc>   dzqfcList=  this.homeService.selectDzq_fc(depCode,type);


        return Res.ok(dzqfcList);
    }


    @RequestMapping("/selectZf_fc")
    public Res<?> selectZf_fc(@RequestParam("depCode") String depCode,@RequestParam("type") String type) {


        List<Zf_fc>   zffcList=  this.homeService.selectZf_fc(depCode,type);


        return Res.ok(zffcList);
    }

    @RequestMapping("/getDzqChildDfp")
    public Res<?> getDzqChildDfp(@RequestParam("depCode") String depCode) {


        List<DzqChildDfp>   dzqChildDfpList=  this.homeService.getDzqChildDfp(depCode);


        return Res.ok(dzqChildDfpList);
    }

    @RequestMapping("/getZfChildDfp")
    public Res<?> getZfChildDfp(@RequestParam("depCode") String depCode) {


        List<ZfChildDfp>   zfChildDfpList=  this.homeService.getZfChildDfp(depCode);


        return Res.ok(zfChildDfpList);
    }
}
