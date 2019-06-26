package webadv.s162031.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.entity.WebManage;
import webadv.s162031.demo.repository.SchoolmanageRepository;
import webadv.s162031.demo.repository.UserRepository;
import webadv.s162031.demo.repository.WebManageRepository;
import webadv.s162031.demo.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yjp
 *
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SchoolmanageRepository schoolmanageRepository;
    @Autowired
    WebManageRepository webManageRepository;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }


@RequestMapping("/login/verify")
@ResponseBody
    public Map<String,String> verylogin(@RequestParam("radionum")int radionum, @RequestParam("account")String account, @RequestParam("password") String password, HttpSession session, Model model){

        Map<String,String> map = new HashMap<>();

    map.put("result","true");
    System.out.println("radio:"+radionum+"\naccount:"+account+"\n:"+password);
    boolean flag = false;
    if(radionum==0){
        User user = userRepository.findByAccountAndPassword(account,password);
        if(user!=null) {
            session.setAttribute("user", user);
            map.put("number","user");
        }else {
            flag=true;
        }
    }else if(radionum ==1){
        Schoolmanage schoolmanage = schoolmanageRepository.findByAccountAndPassward(account,password);
        if(schoolmanage!=null) {
            session.setAttribute("schoolmanage", schoolmanage);
            map.put("number","schoolmanage");

        }else {
            flag=true;
        }
    }else{
        WebManage webManage =webManageRepository.findByAccountAndPassword(account,password);
        if(webManage!=null) {
            session.setAttribute("webManage", webManage);
            map.put("number","webManage");
        }else{
            flag=true;
        }
    }
        if(flag ==true){
            model.addAttribute("errorMeessage","账号密码错误，请重新输入");
            map.put("result","false");
        }
    return map;
}
}
