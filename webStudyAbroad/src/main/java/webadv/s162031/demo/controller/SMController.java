package webadv.s162031.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.School;
import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.service.SMService;
import webadv.s162031.demo.service.imp.SchoolService;

@Controller
public class SMController {


	@Autowired
	private SMService smService;
	@Autowired
	SchoolService schoolService;
	@GetMapping("schoolManagerInfo")
	public String userInfo(Model model) {
		List<Schoolmanage> smInfoList = smService.findAll();
		model.addAttribute("smInfoList", smInfoList);
		return "schoolManagerInfo";
	}
	
	@GetMapping("addSchoolManager")
	public String addSchoolManager() {
		return "addSchoolManager";
	}
	
	@PostMapping("addSchoolManager")
	public String addSchoolManager1(Model model,@RequestParam("number") String account,@RequestParam("password") String password,@RequestParam("schoolID") School schoolID) {
		//insert ѧУ����Ա��Ϣ
		Schoolmanage smInfo = new Schoolmanage();
		smInfo.setAccount(account);
		smInfo.setPassward(password);
		smInfo.setSchool(schoolID);
		smService.saveSMInfo(smInfo);
		//����ѧУ����Ա�б�
		List<Schoolmanage> smInfoList = smService.findAll();
		model.addAttribute("smInfoList", smInfoList);
		return "schoolManagerInfo";
	}
	
	//��ת����Ӧ����Ա��Ϣ���޸Ľ���
		@RequestMapping(value="editSchoolManager",method={RequestMethod.GET})
		public String editSchoolManager(Model model,String smID) {
			Long id = Long.parseLong(smID);
			Schoolmanage smInfo = smService.findByID(id);
			
			model.addAttribute("smInfo", smInfo);
			return "editSchoolManager";	
			
		}
		
		//�޸���ӦѧУ����Ա��Ϣ
		@PostMapping("/editSchoolManager")
		public String editSchoolManager1(Model model,@RequestParam("id") Long smID,@RequestParam("number") String account,@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("schoolID") long schoolID) {
			//�޸���Ӧ��ϢbyID
			Schoolmanage smInfo = smService.findByID(smID);

			smInfo.setAccount(account);
			smInfo.setPassward(password);
			School schoolInfo = schoolService.findByID(schoolID);
			smInfo.setSchool(schoolInfo);
			smService.updataByID(smInfo);
			
			//�����޸ĺ��ѧУ����Ա��Ϣ����
			List<Schoolmanage> smInfoList = smService.findAll();
			model.addAttribute("smInfoList", smInfoList);
			return "schoolManagerInfo";
			
		}
		
		//ɾ����ӦѧУ����Ա��Ϣ
		@GetMapping("deleteSchoolManager")
		public String deleteSchool(Model model,String smID) {
			//ɾ��ָ��IDѧУ��Ϣ
			Long id = Long.parseLong(smID);
			smService.deleteSMInfo(id);
			
			//�����޸ĺ��ѧУ����Ա��Ϣ����
			List<Schoolmanage> smInfoList = smService.findAll();
			model.addAttribute("smInfoList", smInfoList);
			return "schoolManagerInfo";
			
			
		}
}
