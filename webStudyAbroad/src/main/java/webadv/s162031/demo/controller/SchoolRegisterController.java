package webadv.s162031.demo.controller;


import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import webadv.s162031.demo.annotation.LoginRequire;
import webadv.s162031.demo.entity.AbroadApply;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.repository.SchoolRepository;
import webadv.s162031.demo.repository.SchoolmanageRepository;
import webadv.s162031.demo.service.IAbroadApplyService;
import webadv.s162031.demo.service.IAbroadExamService;


@Controller
public class SchoolRegisterController implements WebMvcConfigurer {
	
@Autowired
private IAbroadApplyService abroadApplyService;
@Autowired
private IAbroadExamService abroadExamService;
@Autowired
private SchoolRepository schoolRepository;
@Autowired
private IAbroadApplyService abroadapplyService;
	
//���������Ż�ȡ��ϸ������Ϣ
@LoginRequire(check = true)
@RequestMapping(value="/applicationmessage/{apId}",method = RequestMethod.GET)
public String application(@PathVariable String apId,ModelMap model){
	
     AbroadApply abroadApply=abroadApplyService.findApply(Integer.parseInt(apId));
     
     model.addAttribute("abroadApply", abroadApply);
     
 	 model.addAttribute("status", abroadapplyService.getApplyStatus(abroadApply.getApId()));
	
return"applicationmessage";
}


//��ȡ������Ϣ�б�
@LoginRequire(check = true)
@RequestMapping(value="/abroadexamination",method = RequestMethod.GET)
public String schoolprofiledetail(ModelMap model,HttpSession session){
	
	
	Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
	
	List<AbroadApply> abroadApplyList=abroadApplyService.getowerApplyList(schoolmanage.getId());
	
	model.addAttribute("abroadApplyList", abroadApplyList);
	
return"abroadexamination";
}

//ͬ������
@RequestMapping(value="/applyagree/{apId}",method = RequestMethod.GET)
public String applyagree(@PathVariable String apId,ModelMap model,HttpSession session){
	
	 AbroadApply abroadApply=abroadApplyService.findApply(Integer.parseInt(apId));
	 
	 Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
	 
	 abroadExamService.agreeapply(abroadApply, schoolmanage);
	 
	 List<AbroadApply> abroadApplyList=abroadApplyService.getowerApplyList(schoolmanage.getId());
		
	model.addAttribute("abroadApplyList", abroadApplyList);
		
	return"abroadexamination";
}

//�ܾ�����
@LoginRequire(check = true)
@RequestMapping(value="/applyrject/{apId}",method = RequestMethod.GET)
public String agreeerject(@PathVariable String apId,ModelMap model,HttpSession session){
	
	 AbroadApply abroadApply=abroadApplyService.findApply(Integer.parseInt(apId));
	 
	 Schoolmanage schoolmanage=(Schoolmanage) session.getAttribute("schoolmanage");
	 
	 abroadExamService.rejectapply(abroadApply, schoolmanage);
	 
	 List<AbroadApply> abroadApplyList=abroadApplyService.getowerApplyList(schoolmanage.getId());
		
	model.addAttribute("abroadApplyList", abroadApplyList);
		
	return"abroadexamination";
	

}

}

