package webadv.s162031.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webadv.s162031.demo.annotation.LoginRequire;
import webadv.s162031.demo.entity.*;
import webadv.s162031.demo.service.PostReplayService;
import webadv.s162031.demo.service.PostService;
import webadv.s162031.demo.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: yjp
 * @date:
 * @description:
 */
@Controller
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    PostReplayService postReplayService;
    /**
     * 点击到达论坛交流主页面
     * @return
     */
    @GetMapping("/post/index")
    public String toPostIndex(Model model){
        List<Post> postList =  postService.findAll();
        model.addAttribute("postList",postList);
        return "post/post_index";
    }

    /**
     * 点击到达论坛贴子内容
     * @return
     */
    @GetMapping("post/post_content")
    public String testPostContent(){
        return "post/post_content";
    }

    /**
     * 点击到达论坛交流主页面
     * @return
     */
    @LoginRequire(check = true)
    @GetMapping("post/mypost")
    public String testmyPost(Model model,HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");
       if(user!=null) {
           List<Post> posts = postService.findAllByUser(user);

           model.addAttribute("postlist", posts);
       }
        return "post/post_myself";
    }

    /**
     * 添加帖子
     *
     */
    @LoginRequire(check = true)
    @RequestMapping("/addPost")
    @ResponseBody
    public Boolean addPost(@RequestParam("ptitle")String ptitle,@RequestParam("pcontext")String pcontext,HttpSession session){
        System.out.println("title:"+ptitle+"\n context:"+pcontext);
        User user = (User)session.getAttribute("user");
        postService.savePost(ptitle,pcontext,user.getId());
        return true;
    }

    /**
     * 进入帖子详细信息
     * 1. 帖子的浏览量加1
     * 2. 获得当前session
     */
   @GetMapping("/post/cotent/{postid}")
   public  String goPostConten(@PathVariable(value ="postid")long postid, Model model){
        postService.addViewCount(postid);   //浏览量加1

       Post post = postService.findById(postid);

       List<Postreply> postreplies = postReplayService.findAllByPost(post);

       model.addAttribute("post",post);
       model.addAttribute("postreplielist",postreplies);
    return "post/post_content";
   }


   @GetMapping("/delete/post/{postid}")
    public String deletePost(@PathVariable("postid")long postid ){
       postService.deleteById(postid);
       return "redirect:/post/mypost";
   }

   @GetMapping("post/hot")
    public String postHot(Model model){
       List<Post> postList =  postService.findAllOrderByViewCount();
       model.addAttribute("postList",postList);
       return "post/post_hot";
   }
}
