package webadv.s162031.demo.service;

import java.util.List;

import webadv.s162031.demo.entity.AbroadApply;

public interface IAbroadApplyService {
	
	void saveApply(AbroadApply abroadApply);
	
	List<AbroadApply> getApplyList();
	
	AbroadApply findApply(int apId);
	
	AbroadApply findowerApply(long l);

	 List<AbroadApply> getowerApplyList(long id);
	 
	 String getApplyStatus(int apId);
}
