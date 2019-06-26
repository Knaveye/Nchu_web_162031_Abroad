package webadv.s162031.demo.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import webadv.s162031.demo.annotation.LoginRequire;
import webadv.s162031.demo.entity.AbroadApply;
import webadv.s162031.demo.entity.School;

import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.service.IAbroadApplyService;
import webadv.s162031.demo.service.ISchoolService;
import webadv.s162031.demo.service.UserService;


@Controller
public class UserController implements WebMvcConfigurer {
	
	@Autowired
	private ISchoolService schoolService;
	@Autowired
	private IAbroadApplyService abroadapplyService;


	@Autowired
	private UserService userService;
	
//�����ύҳ��
@LoginRequire(check = true)
@RequestMapping(value="/abroadapplication",method = RequestMethod.GET)
public String abroadapplication(ModelMap model){
	
	AbroadApply abroadApply=new AbroadApply();
	
	model.addAttribute("abroadApply", abroadApply);
	
    ArrayList<School> schoolList=schoolService.getSchoolList();
	
	model.addAttribute("schoolList",schoolList);
	
return"abroadapplication";
	}

//�����û������ύ
@LoginRequire(check = true)
@RequestMapping(value="/applycommit",method = RequestMethod.GET)
public String applycommit(AbroadApply abroadApply,ModelMap model,HttpSession session){
	
	User user=(User) session.getAttribute("user");
	
	abroadApply.setUser(user);
	
	abroadapplyService.saveApply(abroadApply);
	
	School school=schoolService.getSchool(abroadApply.getSchool().getId());
	
	abroadApply.setSchool(school);
	
	model.addAttribute("abroadApply", abroadApply);
	
	model.addAttribute("status", abroadapplyService.getApplyStatus(abroadApply.getApId()));
	
	
	return "userapplication";  
	
	}

//�鿴�û���ѧ����
@LoginRequire(check = true)
@RequestMapping(value="/findownapply",method = RequestMethod.GET)
public String findownapply(ModelMap model,HttpSession session){
	
	User user=(User) session.getAttribute("user");
	
	
	AbroadApply abroadApply=abroadapplyService.findowerApply(user.getId());
	
	School school=schoolService.getSchool(abroadApply.getSchool().getId());
	
	abroadApply.setSchool(school);	
	
	model.addAttribute("abroadApply", abroadApply);
	
	model.addAttribute("status", abroadapplyService.getApplyStatus(abroadApply.getApId()));
	
	return "userapplication";  
	
	}

	//跳转至用户信息界面
	@GetMapping("/userInfo")
	public String userInfo(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "userInfo";
	}
	//跳转添加用户界面
	@GetMapping("/addUser")
	public String addUserGet(Model model) {
		return "addUser";
	}
	//insert用户信息
	@PostMapping("/addUser")
	public String addUserPost(Model model, @RequestParam("number") String account, @RequestParam("email") String email, @RequestParam("name") String name, @RequestParam("password") String password) {
		//insert用户信息
		User userInfo = new User();
		userInfo.setAccount(account);

		userInfo.setPassword(password);
		userInfo.setEmail(email);
		userInfo.setName(name);
		userService.addUser(userInfo);

		//跳转用户信息界面
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "userInfo";

	}
	//跳转至相应用户信息的修改界面
	@RequestMapping(value="editUser",method={RequestMethod.GET})
	public String editSchool(Model model,String userID) {
		Long id = Long.parseLong(userID);
		User userInfo = userService.findById(id);

		model.addAttribute("user", userInfo);
		return "editUser";

	}
	//修改相应用户信息
	@PostMapping("/editUser")
	public String editUser1(Model model,@RequestParam("id") Long userID,@RequestParam("number") String account,@RequestParam("email") String email,@RequestParam("name") String name,@RequestParam("password") String password) {
		//修改相应信息byID
		User userInfo = userService.findById(userID);

		userInfo.setAccount(account);
		userInfo.setEmail(email);
		userInfo.setName(name);
		userInfo.setPassword(password);
		userService.updataByID(userInfo);

		//返回修改后的学校信息界面
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "userInfo";

	}
	//删除对应用户信息
	@GetMapping("deleteUser")
	public String deleteSchool(Model model,String userID) {
		//删除指定ID学校信息
		Long id = Long.parseLong(userID);
		userService.deleteUserInfo(id);

		//返回修改后的学校信息界面
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "userInfo";


	}
}

