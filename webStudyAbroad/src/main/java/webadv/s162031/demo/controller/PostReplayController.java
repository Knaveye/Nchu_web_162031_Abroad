package webadv.s162031.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import webadv.s162031.demo.annotation.LoginRequire;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.entity.WebManage;
import webadv.s162031.demo.service.PostReplayService;
import webadv.s162031.demo.service.PostService;
import webadv.s162031.demo.service.UserService;

import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yjp
 * @date:
 * @description:
 */
@Controller
public class PostReplayController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    PostReplayService postReplayService;

    /**
     * 将回复的内容保存到帖子
     * @param replaynews
     * @return
     */
    @LoginRequire(check = true)
    @RequestMapping("/post/sendreplay")
    @ResponseBody
    public Boolean topostreplay(@RequestParam("replaynews") String replaynews, @RequestParam("postid")long postid, HttpSession session){

        System.out.println("saas");
        User user =(User)session.getAttribute("user");
        Schoolmanage schoolmanage =(Schoolmanage)session.getAttribute("schoolmanage");
        WebManage webManage =(WebManage)session.getAttribute("webManage");
        if(user!=null){
            postReplayService.saveUserReplay(replaynews,postid,user.getId());
        }else if(schoolmanage !=null){
            postReplayService.saveSchoolReplay(replaynews,postid,schoolmanage.getId());
        }else if(webManage!=null){
            postReplayService.saveWebReplay(replaynews,postid,webManage.getId());
        }
        System.out.println("dsfhsdjksjdkfhds");
        return true;
    }
}
