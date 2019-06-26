package webadv.s162031.demo.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webadv.s162031.demo.entity.AbroadApply;
import webadv.s162031.demo.entity.AbroadExam;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.repository.AbroadExamRespository;
import webadv.s162031.demo.service.IAbroadExamService;

@Service
public class AbroadExamService implements IAbroadExamService {


	@Autowired
	private AbroadExamRespository abroadExamRespository;


	public void agreeapply(AbroadApply abroadApply,Schoolmanage schoolRegister) {


		AbroadExam abroadExam=new AbroadExam();
		abroadExam.setAbroadApply(abroadApply);
		abroadExam.setSchoolRegister(schoolRegister);
		abroadExam.setApexStatus("同意申请");
		if(abroadExamRespository.findAbroadExamByAbroadApply(abroadApply)==null) {
			abroadExamRespository.save(abroadExam);
		}
		else {
			abroadExam=abroadExamRespository.findAbroadExamByAbroadApply(abroadApply);
			abroadExam.setApexStatus("同意申请");
			abroadExam.setAbroadApply(abroadApply);
			abroadExam.setSchoolRegister(schoolRegister);
			abroadExamRespository.save(abroadExam);

		}

	}

	public void rejectapply(AbroadApply abroadApply,Schoolmanage schoolRegister) {


		AbroadExam abroadExam=new AbroadExam();
		abroadExam.setAbroadApply(abroadApply);
		abroadExam.setSchoolRegister(schoolRegister);
		abroadExam.setApexStatus("拒绝申请");
		if(abroadExamRespository.findAbroadExamByAbroadApply(abroadApply)==null) {
			abroadExamRespository.save(abroadExam);
		}
		else {
			abroadExam=abroadExamRespository.findAbroadExamByAbroadApply(abroadApply);
			abroadExam.setApexStatus("拒绝申请");
			abroadExam.setAbroadApply(abroadApply);
			abroadExam.setSchoolRegister(schoolRegister);
			abroadExamRespository.save(abroadExam);

		}


	}



}
