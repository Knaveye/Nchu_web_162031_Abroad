package webadv.s162031.demo.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import webadv.s162031.demo.DetailUtil;
import webadv.s162031.demo.annotation.LoginRequire;
import webadv.s162031.demo.entity.StudyAbroadLaw;
import webadv.s162031.demo.entity.StudyAnnounce;
import webadv.s162031.demo.entity.WebManage;
import webadv.s162031.demo.service.RuleService;

@Controller
public class RuleController {//管理规定controller
	@Autowired
	RuleService ruleService;

	@GetMapping("/manageRule")
	public String tomanageRule(Model model){//管理规定
		List<StudyAbroadLaw> rulelist=ruleService.findAlLaws();
		model.addAttribute("rulelist",rulelist);
		return "manageRule";
	}

	@GetMapping("/ruleDetail")
	public String ruleDetail(Model model,String ruleid) {
		StudyAbroadLaw studyAbroadLaw=ruleService.findByid(Long.parseLong(ruleid));
		model.addAttribute("rule", studyAbroadLaw);
		return "detail";
	}
	@LoginRequire(check = true)
	@GetMapping("/oprateRule")
	public String tooprateAnnounce(Model model){
		List<StudyAbroadLaw> list=ruleService.findAlLaws();
		model.addAttribute("rulelist", list);
		return "oprateRules";
	}
	@LoginRequire(check = true)
	@GetMapping("/deleteRule")
	public String deletRule(Model model,String ruleid){
		Long id=Long.parseLong(ruleid);
		String msg=ruleService.deleteRule(id);
		List<StudyAbroadLaw> list=ruleService.findAlLaws();
		model.addAttribute("rulelist", list);
		return "oprateRules";
	}
	@LoginRequire(check = true)
	@GetMapping("/toaddRule")
	public String toaddRule(Model model){//转到发布管理规定界面
		return "addRule";
	}
	@LoginRequire(check = true)
	@PostMapping("/addRuleForm")
	public String toaddRuleForm(Model model,@RequestParam("title") String title,@RequestParam("filename") String filename,@RequestParam("rulefile") MultipartFile file,HttpSession session) throws IOException, Exception {
		StudyAbroadLaw studyAbroadLaw=new StudyAbroadLaw();
		studyAbroadLaw.setTime(new Date());
		WebManage webManage=(WebManage) session.getAttribute("webManage");
		studyAbroadLaw.setWebManage(webManage);
		studyAbroadLaw.setTitle(title);
		String nameString=ruleService.uploadFile(file);
		studyAbroadLaw.setFilename(nameString);
		studyAbroadLaw.setContent("normal");
		String filepath="../webStudyAbroad/src/main/resources/static/txt/"+nameString;
		studyAbroadLaw.setFileath(filepath);
		ruleService.addRule(studyAbroadLaw);
		List<StudyAbroadLaw> list=ruleService.findAlLaws();
		model.addAttribute("rulelist", list);
		return "oprateRules";
	}

	/*
	 * 文件下载
	 * */
	@GetMapping("/rule/downloadFile")
	public void downloadFile(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path="../webStudyAbroad/src/main/resources/static/txt/ruleOnline.pdf";
		File imageFile = new File(path);
		if (!imageFile.exists()) {
			return;
		}

		//下载的文件携带这个名称
		response.setHeader("Content-Disposition", "attachment;filename=" + "ruleOnline.pdf");
		//文件下载类型--二进制文件
		response.setContentType("application/octet-stream");

		try {
			FileInputStream fis = new FileInputStream(path);
			byte[] content = new byte[fis.available()];
			fis.read(content);
			fis.close();

			ServletOutputStream sos = response.getOutputStream();
			sos.write(content);

			sos.flush();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
