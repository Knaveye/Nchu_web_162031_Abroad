package webadv.s162031.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.repository.UserRepository;
import webadv.s162031.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: yjp
 * @date:
 * @description:
 */
@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String toRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register/user")
    public String registerUser(@Validated User user, HttpSession session){
        userService.addUser(user);
        User user1 = userService.findByAccountAndPassword(user.getAccount(),user.getPassword());
        session.setAttribute("user",user1);
        return  "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }
@GetMapping("/nologin")
    public String nologin(){
        return "/post/nologin";
}
}
