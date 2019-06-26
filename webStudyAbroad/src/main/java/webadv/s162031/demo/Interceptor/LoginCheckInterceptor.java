package webadv.s162031.demo.Interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import webadv.s162031.demo.annotation.LoginRequire;
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
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.判断是否存在注解
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod method = (HandlerMethod)handler;
        boolean hasLoginAnnotation=method.getMethod().isAnnotationPresent(LoginRequire.class);
        if(!hasLoginAnnotation){
            //不存在LoginRequired注解，则直接通过
            return true;
        }
        LoginRequire loginCheck=method.getMethod().getAnnotation(LoginRequire.class);
        //2.required=false,则无需检查是否登录
        if(!loginCheck.check()){
            return true;
        }
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        Schoolmanage schoolmanage =(Schoolmanage)session.getAttribute("schoolmanage");
        WebManage webManage =(WebManage)session.getAttribute("webManage");

        if(user != null || schoolmanage!= null || webManage!=null){
            return true;
        }
        //3.登录状态检查,使用response返回指定信息
        //response.getWriter().append("you need login!");
        //都不符合的时候
        response.sendRedirect("/nologin");
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
