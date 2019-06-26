package webadv.s162031.demo.service;

import java.util.ArrayList;

import webadv.s162031.demo.entity.AbroadRequire;
import webadv.s162031.demo.entity.School;

public interface ISchoolService {

	 ArrayList<School> getSchoolList();
	 
	 School getSchool(long sId);
	 
	 AbroadRequire getSchoolRequire(long sId);

	School findByID(Long id);

	void updataByID(School schoolInfo);

	void saveSchoolInfo(School schoolInfo);

	void deleteSchoolInfo(Long id);
}
