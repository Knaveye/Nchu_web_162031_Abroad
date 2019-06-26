package webadv.s162031.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.repository.SchoolmanageRepository;

@Service
public class SMService {
	private List<Schoolmanage> smInfoList;

	@Autowired
	private SchoolmanageRepository smInfodao;

	//找学校管理员列表
	public List<Schoolmanage> findAll() {
		// TODO Auto-generated method stub
		smInfoList = smInfodao.findAll();
		return smInfoList;
	}

	//insert学校管理员信息
	public void saveSMInfo(Schoolmanage smInfo) {
		// TODO Auto-generated method stub
		smInfodao.save(smInfo);
	}
	//返回相应学校管理员信息
	public Schoolmanage findByID(Long id) {
		// TODO Auto-generated method stub
		Optional<Schoolmanage> smOptional = smInfodao.findById(id);
		if(smOptional.isPresent()) {
			Schoolmanage smInfo = smOptional.get();
			return smInfo;
		}
		return null;
	}
	//修改相应学校管理员信息
	public void updataByID(Schoolmanage smInfo) {
		// TODO Auto-generated method stub
		smInfodao.saveAndFlush(smInfo);
	}
	//删除相应学校管理员信息
	public void deleteSMInfo(Long id) {
		// TODO Auto-generated method stub
		smInfodao.deleteById(id);

	}




}
