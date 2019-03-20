package com.mx.api.application.gis.controller;

import com.mx.api.application.gis.service.GisService;
import com.mx.api.core.config.Config;
import com.mx.api.core.redis.RedisDao;
import com.mx.api.application.gis.model.Gis;
import com.mx.api.utils.BaseController;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 1) 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 2) 如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 */
// @Controller：修饰class，用来创建处理http请求的对象
// @RestController：Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式

@RestController
@RequestMapping("/gisController")
public class GisController {
    Logger logger = LogManager.getLogger(GisController.class);

    @Autowired
    private Config config;
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private GisService gisService;

    @ApiOperation("gis具体信息")
    @GetMapping("/queryVisualByPoint")
    public String queryVisualByPoint(Gis gis){

        return "";
    }

    @ApiOperation("test properties")
    @GetMapping("/configTest")
    public String configTest(){
        return config.getSSO_SERVER_URL();
    }

    @ApiOperation("3.参数是字符串，查询智慧城区")
    @GetMapping("/queryZhcqName")
    public String queryZhcqName(@RequestParam String xzqh,@RequestParam String cqlx) {
        Gis gis = new Gis();
        gis.setXzqh(xzqh);
        gis.setCqlx(cqlx);
        List<Gis> gisList = gisService.queryZhcqName(gis);
        return BaseController.renderNewJson(200, "ok", gisList);
    }
    @ApiOperation("4.参数是model，查询智慧城区")
    @GetMapping("/queryZhcqNameTest")
    public String queryZhcqNameTest(@ModelAttribute Gis gis) {
//        Gis gis = new Gis();
//        gis.setXzqh(xzqh);
//        gis.setCqlx(cqlx);
        List<Gis> gisList = gisService.queryZhcqName(gis);
        return BaseController.renderNewJson(200, "ok", gisList);
    }
    @ApiOperation("4.统一异常处理测试")
    @GetMapping("/exceptionTest")
    public String exceptionTest(@RequestParam String id) throws Exception {
        if(null == id) {
            throw new Exception();
        }

        return "exception";
    }
    @ApiOperation("5.app-system")
    @GetMapping("/queryIpoleAppSystem")
    public String queryIpoleAppSystem() {
        return gisService.queryIpoleAppSystem();
    }


}
