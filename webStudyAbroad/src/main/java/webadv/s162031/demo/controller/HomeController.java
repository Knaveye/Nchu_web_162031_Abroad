package webadv.s162031.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "login";
	}
	 @GetMapping("/news")
	    public String tonews(){
	    	return "news";
	    }
	    
	    @GetMapping("/index")
	    public String toindex(){
	    	return "index";
	    }
	    @GetMapping("/newslist")
	    public String tonewslist(){
	    	return "newslist";
	    }
	    
	    @GetMapping("/announcement")
	    public String toannouncement(){
	    	return "announcement";
	    }
	    @GetMapping("/annDeatils")
	    public String toannDeatils(){
	    	return "annDeatils";
	    }
	    @GetMapping("/declarationGuide")
	    public String todeclarationGuide(){
	    	return "declarationGuide";
	    }
	    @GetMapping("/admission")
	    public String toadmission(){
	    	return "admission";
	    }
	    @GetMapping("/foreginManage")
	    public String toforeginManage(){
	    	return "foreginManage";
	    }
	    @GetMapping("/cooperative")
	    public String tocooperative(){//��������
	    	return "cooperative";
	    }
	    @GetMapping("/manageRule")
	    public String tomanageRule(){//����涨
	    	return "manageRule";
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
