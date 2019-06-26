package webadv.s162031.demo.service.imp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webadv.s162031.demo.entity.AbroadRequire;
import webadv.s162031.demo.entity.School;
import webadv.s162031.demo.repository.AboradRequireRepository;
import webadv.s162031.demo.repository.SchoolRepository;
import webadv.s162031.demo.service.ISchoolService;

@Service
public class SchoolService implements ISchoolService{

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private AboradRequireRepository abroadrequireRepositroy;
	
	public ArrayList<School> getSchoolList(){
		
		return (ArrayList<School>) schoolRepository.findAll();
	}
   public School getSchool(long sId){
		
	   Optional<School> school=schoolRepository.findById(sId);
		return  school.get();
	}
   public AbroadRequire getSchoolRequire(long sId){
	  Optional<School> school=schoolRepository.findById(sId);
	  return abroadrequireRepositroy.findAboradRequireBySchool(school.get());
	}

	@Override
	public School findByID(Long id) {
		return schoolRepository.findById(id).orElse(null);
	}

	@Override
	public void updataByID(School schoolInfo) {
		schoolRepository.save(schoolInfo);
	}

	@Override
	public void saveSchoolInfo(School schoolInfo) {
		schoolRepository.save(schoolInfo);
	}

	@Override
	public void deleteSchoolInfo(Long id) {
		schoolRepository.deleteById(id);
	}

}
