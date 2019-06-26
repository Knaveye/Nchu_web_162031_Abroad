package webadv.s162031.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webadv.s162031.demo.entity.StudyAbroadLaw;
import webadv.s162031.demo.service.RuleService;

@Controller
public class ForeignController {//国外管理页面

	@Autowired
	RuleService ruleService;
	@GetMapping("/foreignRuleDetail")
	public String ruleDetail(Model model,String ruleid) {
		StudyAbroadLaw studyAbroadLaw=ruleService.findByid(Long.parseLong(ruleid));
		model.addAttribute("rule", studyAbroadLaw);
		return "detail";
	}
	@GetMapping("/foreginManage")
	public String toforeginManage(Model model){
		List<StudyAbroadLaw> rulelist=ruleService.findForeignLaws();
		model.addAttribute("foreignrulelist",rulelist);
		return "foreginManage";
	}

}
