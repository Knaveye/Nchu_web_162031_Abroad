package webadv.s162031.demo.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webadv.s162031.demo.entity.AbroadApply;
import webadv.s162031.demo.entity.AbroadExam;
import webadv.s162031.demo.entity.School;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.repository.*;

import webadv.s162031.demo.service.IAbroadApplyService;

@Service
public class AbroadApplyService implements IAbroadApplyService {

	@Autowired
	private AbroadApplyRepository abroadApplyRepository;
	@Autowired
	private SchoolmanageRepository  schoolmanagerRepository;
	@Autowired
	private SchoolRepository schoolRepositroy;
	@Autowired
	private AbroadExamRespository abroadExamRespository;

	public void saveApply(AbroadApply abroadApply) {
		abroadApplyRepository.save(abroadApply);
	}

	public List<AbroadApply> getApplyList() {
		return abroadApplyRepository.findAll();
	}

	public AbroadApply findApply(int apId) {
		Optional<AbroadApply> abroadApply=abroadApplyRepository.findById(apId);
		return abroadApply.get();

	}

	public AbroadApply findowerApply(long userId) {

		return abroadApplyRepository.findAbroadApplyByUserId(userId);

	}

	public List<AbroadApply> getowerApplyList(long id) {
		// TODO Auto-generated method stub
		Optional<Schoolmanage> schoolmanage=schoolmanagerRepository.findById(id);

		Optional<School> school=schoolRepositroy.findById(schoolmanage.get().getSchool().getId());

		List<AbroadApply> abroadApplies=abroadApplyRepository.findAbroadApplysBySchool(school.get()) ;

		return abroadApplies;


	}

	public String getApplyStatus(int apId) {

		Optional<AbroadApply> abroadApply=abroadApplyRepository.findById(apId);

		AbroadExam abroadExam=abroadExamRespository.findAbroadExamByAbroadApply(abroadApply.get());

		if(abroadExam==null) {
			return "审核中";
		}
		if(abroadExam.getApexStatus().equals("同意申请")) {
			return "申请通过";
		}
		if(abroadExam.getApexStatus().equals("拒绝申请")) {
			return "申请未通过";
		}
		else
			return "审核中";

	}

}
