package webadv.s162031.demo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.entity.WebManage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: yjp
 * @date:
 * @description:
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        if(uri.indexOf("/login")>=0){
            return  true;
        }
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        Schoolmanage schoolmanage =(Schoolmanage)session.getAttribute("schoolmanage");
        WebManage webManage =(WebManage)session.getAttribute("webManage");

        if(user != null || schoolmanage!= null || webManage!=null){
            return true;
        }
        //都不符合的时候
        request.setAttribute("msg","您还没登录，请先登录！");
        request.getRequestDispatcher("/nologin").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
