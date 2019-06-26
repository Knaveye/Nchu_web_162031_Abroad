package webadv.s162031.demo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import webadv.s162031.demo.annotation.LoginRequire;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.StudyAbroad;
import webadv.s162031.demo.entity.StudyAnnounce;
import webadv.s162031.demo.service.NewsService;

@Controller
public class NewsController {
	@Autowired
	NewsService newsService;

	@GetMapping("/news")
	public String tonews(Model model){//首页的新闻列表
		List<StudyAbroad> newsli=newsService.top5list();
		model.addAttribute("newsli",newsli);
		model.addAttribute("onenews", newsli.get(0));
		return "news";
	}

	@GetMapping("/newslist")
	public String tonewslist(Model model){//查询所有新闻
		List<StudyAbroad> newslist=newsService.top5list();
		model.addAttribute("newslist",newslist);
		model.addAttribute("thenews", newslist.get(0));
		return "newslist";
	}

	@RequestMapping("/newslist/refershlist")
	public String refershNews(Model model,String newsid) {
		Long id=Long.parseLong(newsid);
		StudyAbroad thenews=newsService.findOneNews(id);
		model.addAttribute("thenews", thenews);
		return "newslist::refresh-it";
	}
	@RequestMapping("/refersh")
	public String refersh(Model model,String newsid) {
		Long id=Long.parseLong(newsid);
		StudyAbroad thenews=newsService.findOneNews(id);
		model.addAttribute("onenews", thenews);
		return "news::refresh-one";
	}
	@LoginRequire(check = true)
	@GetMapping("/manageNews")
	public String manageNews(Model model,HttpSession session){//管理新闻
		Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
		List<StudyAbroad> list=newsService.findlistBySchoolManage(schoolmanage);
		model.addAttribute("newslist", list);
		return "manageNews";
	}
	@LoginRequire(check = true)
	@GetMapping("/deleteNews")
	public String deleteNews(Model model,String newsid,HttpSession session){//删除新闻
		Long id=Long.parseLong(newsid);
		String msg=newsService.deletenews(id);
		Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
		List<StudyAbroad> list=newsService.findlistBySchoolManage(schoolmanage);
		model.addAttribute("newslist", list);
		return "manageNews";
	}
	@LoginRequire(check = true)
	@GetMapping("/toaddNews")
	public String toaddNews(Model model){//转到发布公告界面
		return "addNews";
	}
	@LoginRequire(check = true)
	@PostMapping("/addNewsform")
	public String toaddAnnForm(Model model,@RequestParam("title") String title,@RequestParam("content") String content,HttpSession session) throws IOException, Exception{//发布公告
		StudyAbroad studyAbroad=new StudyAbroad();
		studyAbroad.setTitle(title);
		studyAbroad.setContent(content);
		studyAbroad.setTime(new Date());
		Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
		studyAbroad.setSchoolmanage(schoolmanage);
		newsService.addnews(studyAbroad);
		List<StudyAbroad> list=newsService.findlistBySchoolManage(schoolmanage);
		model.addAttribute("newslist", list);
		return "manageNews";
	}
}
