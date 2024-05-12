package com.hejmls.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.hejmls.pojo.Result;
import com.hejmls.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import com.aliyuncs.utils.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class loginCheakInterceptor implements HandlerInterceptor {
    @Override//运行前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle//////////");

        //1 获取请求的url
        String url = request.getRequestURI().toString();
        log.info("请求的URL{}:", url);
        //2 判断是否为login
        if (url.contains("login")) {
            log.info("登录操作。。。。");
            return true;

        }
        //3 获取请求头中的令牌
        String jwt = request.getHeader("Authorization");
        if (jwt != null && jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7); // 7 是 "Bearer " 的长度
        }
        System.out.println("jwt:" + jwt);

        //4 判断令牌是否存在
        if (StringUtils.isEmpty(jwt)) {
            log.info("令牌为空？？？？？");
            Result error = Result.error("NOT_LOGIN");
            //对象转换成json
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        //5 解析令牌
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//解析失败

            e.printStackTrace();
            log.info("解析失败");
            Result error = Result.error("NOT_LOGIN");
            //对象转换成json
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        //6 放行
        log.info("合法，通过");
        return true;
    }

    @Override//运行后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle//////////");
    }

    @Override//视图渲染完毕后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("aftercompletion//////////");
    }
}
