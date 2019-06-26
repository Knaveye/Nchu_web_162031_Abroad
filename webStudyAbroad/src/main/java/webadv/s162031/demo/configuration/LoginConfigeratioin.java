package webadv.s162031.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import webadv.s162031.demo.Interceptor.LoginCheckInterceptor;
import webadv.s162031.demo.Interceptor.LoginInterceptor;

/*
 * @author: yjp
 * @date:
 * @description:
*/

@Configuration
public class LoginConfigeratioin implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
       // LoginInterceptor loginInterceptor = new LoginInterceptor();
        //InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        LoginCheckInterceptor  loginInterceptor =new  LoginCheckInterceptor();
        InterceptorRegistration loginRegistry =registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/logout");
        // 排除资源请求
        loginRegistry.excludePathPatterns("/css/**");
        loginRegistry.excludePathPatterns("/js/**");
        loginRegistry.excludePathPatterns("/images/**");
        loginRegistry.excludePathPatterns("/vendors/**");
        loginRegistry.excludePathPatterns("/build/**");
    }
}
