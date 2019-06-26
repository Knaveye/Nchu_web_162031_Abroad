package webadv.s162031.demo.service;

import webadv.s162031.demo.entity.AbroadApply;
import webadv.s162031.demo.entity.Schoolmanage;

public interface IAbroadExamService {
	void agreeapply(AbroadApply abroadApply, Schoolmanage schoolRegister);
	void rejectapply(AbroadApply abroadApply, Schoolmanage schoolRegister);
	
}
