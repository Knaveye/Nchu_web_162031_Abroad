package webadv.s162031.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexController {//首页跳转所用的controller
	
	    
	    @GetMapping("/index")
	    public String toindex(){
	    	return "index";
	    }
	   
	    
	  
	    
	    @GetMapping("/declarationGuide")
	    public String todeclarationGuide(){
	    	return "declarationGuide";
	    }
	  
	   
	    @GetMapping("/cooperative")
	    public String tocooperative(){//合作机构
	    	return "cooperative";
	    }
	    
	    @GetMapping("/contact")
	    public String tocontact(){//联系方式
	    	return "contact";
	    }
	    @GetMapping("/institutionSet")
	    public String toinstitutionSet(){//机构设置
	    	return "institutionSet";
	    }
	    @GetMapping("/introduction")
	    public String tointroduction(){//机构介绍
	    	return "introduction";
	    }
}
