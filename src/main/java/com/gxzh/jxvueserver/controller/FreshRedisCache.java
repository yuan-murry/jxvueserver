package com.gxzh.jxvueserver.controller;

import com.gxzh.jxvueserver.dto.Res;
import com.gxzh.jxvueserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/freshcache")
public class FreshRedisCache {
    @Autowired
    private HomeService homeService;
    @Autowired
    private AnalyzeService analyzeService;
    @Autowired
    private BzzyService bzzyService;
    @Autowired
    private CompareService compareService;
    @Autowired
    private WtyjService wtyjService;
    @Autowired
    private ZzbzService zzbzService;
    @Autowired
    private RedisTemplate redisTemplate;
    private final String[] depArr = {"36%", "360000", "3601%", "3602%", "3603%", "3604%", "3605%", "3606%", "3607%", "3608%", "3609%", "3610%", "3611%", "360100", "360200", "360300", "360400", "360500", "360600", "360700", "360800", "360900", "361000", "361100"};

    private final String[] depArrAnalyse = {"36__00", "3601%", "3602%", "3603%", "3604%", "3605%", "3606%", "3607%", "3608%", "3609%", "3610%", "3611%"};

    private final String[] depArrBzzy = {"36%", "360100", "360200", "360300", "360400", "360500", "360600", "360700", "360800", "360900", "361000", "361100"};

    @RequestMapping("/index")
    public String showIndex(ModelMap map) {
        Object o = redisTemplate.opsForValue().get("jxvue:database");
        String databaseName = "";
        if(o!=null){
            databaseName = (String) o;
        }
        map.put("dataName",databaseName);

        return "freshdata";
    }

    @RequestMapping("/doFresh")
    @ResponseBody
    public Res<?> doFresh() {
        StringBuilder reurnMsg = new StringBuilder(128);
        //home ????????????
        Set<String> keys = redisTemplate.keys("vuejx:home:" + "*");
        redisTemplate.delete(keys);
        Set<String> keys2 = redisTemplate.keys("vuejx:analyze:" + "*");
        redisTemplate.delete(keys2);
        Set<String> keys3 = redisTemplate.keys("vuejx:bzzy:" + "*");
        redisTemplate.delete(keys3);
        Set<String> keys4 = redisTemplate.keys("vuejx:compare:" + "*");
        redisTemplate.delete(keys4);
        Set<String> keys5 = redisTemplate.keys("vuejx:wtyj:" + "*");
        redisTemplate.delete(keys5);
        //home????????????
        try {
            for (String dep : depArr) {
                homeService.selectBzqk(dep);
                homeService.selectSydwpie(dep);
                homeService.selectXzjgpie(dep);
                homeService.selectXzLdzs(dep);
                homeService.selectSyLdzs(dep);
            }
            reurnMsg.append("home????????????????????????<br>");
            for (String dep : depArrAnalyse) {
                analyzeService.selectGdyw(dep);
                analyzeService.selectJryw(dep);
                analyzeService.selectNywbl(dep);
                analyzeService.selectYwlx(dep);
                analyzeService.selectYywbl(dep);
            }
            reurnMsg.append("analyse????????????????????????<br>");
            for (String dep : depArrBzzy) {
                bzzyService.getBzzyBzlx(dep);
                bzzyService.getLdzspie(dep);
                bzzyService.getInsdstry(dep);
                bzzyService.getRetire(dep);
                bzzyService.getXzbzpie(dep);
                bzzyService.getNoUse(dep);
            }
            reurnMsg.append("bzzy????????????????????????<br>");
            for (String dep : depArrAnalyse) {
                compareService.selectSybzpzbd(dep);
                compareService.selectLdzs(dep);
                compareService.selectXzbzpzbd(dep);
            }
            reurnMsg.append("compare????????????????????????<br>");
            for (String dep : depArrAnalyse) {
                wtyjService.selectCbz(dep);
            }
            reurnMsg.append("wtyj????????????????????????<br>");
            for (String dep : depArrBzzy) {
                zzbzService.getGeneralUse(dep);
                zzbzService.getRecycle(dep);
                zzbzService.getRetire(dep);
                zzbzService.getStaffDuty(dep);
                zzbzService.getZzbzAllot(dep);
                zzbzService.getUseCondition(dep);
            }
            reurnMsg.append("zzbz????????????????????????<br>");
        }catch (Exception e){
            System.out.println("?????????????????????" + e);
            reurnMsg.append("?????????????????????" + e);
        }finally {
            return Res.ok(reurnMsg.toString());
        }
    }

    @GetMapping("/changeDataBase")
    @ResponseBody
    public Res<?> changeDataBase(String dataBase){
        redisTemplate.opsForValue().set("jxvue:database",dataBase);
        return Res.ok("????????????");
    }
}
