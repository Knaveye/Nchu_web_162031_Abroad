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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import webadv.s162031.demo.annotation.LoginRequire;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.StudyAnnounce;
import webadv.s162031.demo.service.AnnounceService;

@Controller
public class AnnounceController {
	@Autowired
	AnnounceService announceService;

	@GetMapping("/announcement")
	public String toannouncement(Model model){
		List<StudyAnnounce> list=announceService.findAllAnnounce();
		model.addAttribute("announcelist", list);
		return "announcement";
	}
	@GetMapping("/annDetails")
	public String toannDeatils(Model model,String announceid){
		Long id=Long.parseLong(announceid);
		StudyAnnounce studyAnnounce=announceService.findStudyAnnounceById(id);
		model.addAttribute("announce", studyAnnounce);
		return "annDeatils";
	}

	@GetMapping("/admission")
	public String toadmission(Model model){
		List<StudyAnnounce> annlist=announceService.top4list();
		model.addAttribute("annlist", annlist);
		return "admission";
	}
	@LoginRequire(check = true)
	@GetMapping("/manageAnn")
	public String tomanageAnnounce(Model model,HttpSession session){//管理公告
		Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
		List<StudyAnnounce> list=announceService.findAllBySchamnage(schoolmanage);
		model.addAttribute("announcelist", list);
		return "manageAnnounce";
	}
	@LoginRequire(check = true)
	@GetMapping("/deleteAnn")
	public String deleteAnn(Model model,String announceid,HttpSession session){
		Long id=Long.parseLong(announceid);
		String msg=announceService.deleteAnnounce(id);
		Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
		List<StudyAnnounce> list=announceService.findAllBySchamnage(schoolmanage);
		model.addAttribute("announcelist", list);
		return "manageAnnounce";
	}
	@LoginRequire(check = true)
	@GetMapping("/toaddAnn")
	public String toaddAnn(Model model){//转到发布公告界面
		return "addAnnounce";
	}

	@LoginRequire(check = true)
	@PostMapping("/addAnnform")
	public String toaddAnnForm(Model model,@RequestParam("title") String title,@RequestParam("filename") String filename,@RequestParam("annfile") MultipartFile file,HttpSession session) throws IOException, Exception{//发布公告
		StudyAnnounce studyAnnounce=new StudyAnnounce();
		studyAnnounce.setTime(new Date());
		String nameString=announceService.uploadFile(file);
		studyAnnounce.setFilename(nameString);
		String filepath="../webStudyAbroad/src/main/resources/static/txt/"+nameString;
		studyAnnounce.setFilepath(filepath);
		Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
		studyAnnounce.setSchoolmanage(schoolmanage);
		studyAnnounce.setTitle(title);
		announceService.addAnnounce(studyAnnounce);
		List<StudyAnnounce> list=announceService.findAllBySchamnage(schoolmanage);
		model.addAttribute("announcelist", list);
		return "manageAnnounce";
	}

}
