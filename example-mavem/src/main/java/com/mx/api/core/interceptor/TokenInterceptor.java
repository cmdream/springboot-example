package com.mx.api.core.interceptor;

import com.mx.api.core.config.Config;
import com.mx.api.core.redis.RedisDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    private static final String LOGINURL = "/jsp/login/login.jsp";//登录页面url

    private static final String ICO = "/favicon.ico";

    @Resource
    private RedisDao redisDao;
    @Resource
    private Config config;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndView arg3) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        String url = request.getRequestURI();
        if (log.isInfoEnabled() && !url.contains(ICO) && !url.contains("/img/") && url.contains("/css/") && url.contains("/js/")) {
            System.out.println("【请求时长】: " + request.getRequestURI() + " " + executeTime + "ms");
        }
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        String url = request.getRequestURI();
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        if(!url.contains(config.getNotIntercepted())) {
            String token = request.getHeader("token");
            if(null != token && redisDao.exists(token) && null !=redisDao.get(token)) {
                response.setHeader("token", token);
                redisDao.expire(token, 30*60*1000);
            }else {
                response.setHeader("token", "sessionTimeout");
            }
        }

        // 打印信息
        String referer = request.getHeader("Referer");
        if (referer == null) {
            referer = "new";
        }
        referer = referer.replaceAll("^[^/]+//[^/]+", "");
        System.out.println("【请求地址】: " + request.getRequestURI() + "  " + request.getMethod());
        // 排序输出参数[名称:值]
        Iterator<Map.Entry> it = new TreeMap(request.getParameterMap()).entrySet().iterator();
        int i = 1;
        while (it.hasNext()) {
            Map.Entry<String, String[]> me = it.next();
            System.out.println("【请求参数" + i + "】: " + "【" + me.getKey() + "】" + " 【值】 :【" + me.getValue()[0] + "】");
            i++;
        }
        return true;
    }
}
