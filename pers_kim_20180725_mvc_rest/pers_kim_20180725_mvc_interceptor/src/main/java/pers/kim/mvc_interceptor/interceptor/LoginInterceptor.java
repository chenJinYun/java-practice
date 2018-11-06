package pers.kim.mvc_interceptor.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create on 7/25/2018
 *
 * @Author Kim
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name= (String) request.getSession().getAttribute("name");
        if(StringUtils.isNotBlank(name)){
            return true;
        }else{
            response.sendRedirect("/jsp/login.jsp");
        }
        return false;
    }
}
