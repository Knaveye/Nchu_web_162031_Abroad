package webadv.s162031.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexController {//��ҳ��ת���õ�controller
	
	    
	    @GetMapping("/index")
	    public String toindex(){
	    	return "index";
	    }
	   
	    
	  
	    
	    @GetMapping("/declarationGuide")
	    public String todeclarationGuide(){
	    	return "declarationGuide";
	    }
	  
	   
	    @GetMapping("/cooperative")
	    public String tocooperative(){//��������
	    	return "cooperative";
	    }
	    
	    @GetMapping("/contact")
	    public String tocontact(){//��ϵ��ʽ
	    	return "contact";
	    }
	    @GetMapping("/institutionSet")
	    public String toinstitutionSet(){//��������
	    	return "institutionSet";
	    }
	    @GetMapping("/introduction")
	    public String tointroduction(){//��������
	    	return "introduction";
	    }
}
