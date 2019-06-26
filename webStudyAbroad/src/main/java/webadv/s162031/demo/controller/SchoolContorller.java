package webadv.s162031.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import webadv.s162031.demo.entity.AbroadRequire;
import webadv.s162031.demo.entity.School;
import webadv.s162031.demo.service.ISchoolService;

@Controller
public class SchoolContorller implements WebMvcConfigurer {
	
@Autowired
private ISchoolService schoolService;





@RequestMapping(value="/schoolprofile",method = RequestMethod.GET)
public String schoolprofile(ModelMap model){

	ArrayList<School> schoolList=schoolService.getSchoolList();
	
	model.addAttribute("schoolList",schoolList);
	
	
    return"schoolprofile";
}


//����ID����ѧУ��ϸ��Ϣ
@RequestMapping(value="/schoolprofiledetail/{sId}",method = RequestMethod.GET)
public String schoolprofiledetail(@PathVariable String sId,ModelMap model){
	System.out.print("asdasdasdasdaaaaaaaaaaaaa"+sId);
	
	School school=schoolService.getSchool(Integer.parseInt(sId));
	
	AbroadRequire abroadRequire=schoolService.getSchoolRequire(Integer.parseInt(sId));
	
	model.addAttribute("school",school);
	
	model.addAttribute("abroadRequire",abroadRequire);
	
return"schoolprofiledetail";
}


	//跳转学校信息界面
	@GetMapping("/schoolInfo")
	public String schoolInfo(Model model) {
		List<School> schoolList = schoolService.getSchoolList();
		model.addAttribute("schoolList", schoolList);
		return "schoolInfo";
	}

	//跳转到相应学校的修改界面
	@RequestMapping(value="editSchool",method={RequestMethod.GET})
	public String editSchool(Model model,String schoolID) {
		Long id = Long.parseLong(schoolID);
		School schoolInfo = schoolService.findByID(id);

		model.addAttribute("schoolInfo", schoolInfo);
		return "editSchool";

	}
	//	@PostMapping("/editSchool/{schoolID}")
//	public String schoolInfo(Model model,@PathVariable(name="schoolID") String schoolID,@RequestParam("name") String name) {
//		List<SchoolInfo> schoolList = schoolService.findAll();
//		model.addAttribute("schoolList", schoolList);
//		return "schoolInfo";
//	}
	//修改相应学校信息并跳转回学校信息界面
	@PostMapping("/editSchool")
	public String schoolInfo1(Model model,@RequestParam("id") long id,@RequestParam("name") String name,@RequestParam("website") String url) {
		//修改相应信息byID
	//	System.out.println("id"+ id+"name:"+name);
		 School schoolInfo = schoolService.findByID(id);
		schoolInfo.setName(name);
		schoolInfo.setSchool_net(url);
		schoolService.updataByID(schoolInfo);

		//返回修改后的学校信息界面
		List<School> schoolList = schoolService.getSchoolList();
		model.addAttribute("schoolList", schoolList);
		return "schoolInfo";

	}
	//跳转至添加学校信息界面
	@GetMapping("/addSchool")
	public String addSchool(Model model) {
		return "addSchool";
	}
	//添加学校信息
	@PostMapping("/addSchool")
	public String addSchoolDo(Model model,@RequestParam("name") String name,@RequestParam("website") String url) {
		//insert学校信息
		School schoolInfo = new School();
		schoolInfo.setName(name);
		schoolInfo.setSchool_net(url);
		schoolService.saveSchoolInfo(schoolInfo);
		//返回更新后的学校信息界面
		List<School> schoolList = schoolService.getSchoolList();
		model.addAttribute("schoolList", schoolList);
		return "schoolInfo";
	}

	//删除学校信息
	//@RequestMapping(value="deleteSchool/{schoolID}",method={RequestMethod.GET})
	@GetMapping("deleteSchool")
	public String deleteSchool(Model model, /* @PathVariable(name="schoolID") */String schoolID) {
		//删除指定ID学校信息
		Long id = Long.parseLong(schoolID);
		schoolService.deleteSchoolInfo(id);

		//返回更新后的学校信息界面
		List<School> schoolList = schoolService.getSchoolList();
		model.addAttribute("schoolList", schoolList);
		return "schoolInfo";


	}


}

