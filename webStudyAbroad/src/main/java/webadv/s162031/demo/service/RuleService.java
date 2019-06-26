package webadv.s162031.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webadv.s162031.demo.DetailUtil;
import webadv.s162031.demo.entity.StudyAbroadLaw;
import webadv.s162031.demo.entity.StudyAnnounce;
import webadv.s162031.demo.entity.WebManage;
import webadv.s162031.demo.repository.StudyAbroadLawRepository;

@Service
public class RuleService {
    @Autowired
    StudyAbroadLawRepository studyAbroadLawRepository;
    
    public List<StudyAbroadLaw> findAlLaws() {//��ѯ���й涨
		return studyAbroadLawRepository.findAllRule();
	}
    
    public StudyAbroadLaw findByid(Long id) {
    	StudyAbroadLaw studyAbroadLaw=studyAbroadLawRepository.getOne(id);
		return studyAbroadLaw;
	}
    public List<StudyAbroadLaw> findForeignLaws() {//��ѯ���й������涨
		return studyAbroadLawRepository.findAllForeignRule();
	}
    public String addRule(StudyAbroadLaw studyAbroadLaw) {//��ӹ���涨
    	studyAbroadLawRepository.save(studyAbroadLaw);
    	if(studyAbroadLawRepository.existsById(studyAbroadLaw.getId())) {
    		return "��ӳɹ�";
    	}else {
    		return "���ʧ��";
    	}
    	
    }
    public String deleteRule(Long id) {//ɾ������涨
    	studyAbroadLawRepository.deleteById(id);
    	delfile(id);
    	if(studyAbroadLawRepository.existsById(id)) {
    		return "ɾ��ʧ��";
    	}else {
    		return "ɾ���ɹ�";
    	}
	}
    
    /*
	   * ɾ���涨�ļ�
	   * */
	  public void delfile(Long id){
		  StudyAbroadLaw studyAbroadLaw=studyAbroadLawRepository.getOne(id);
	        try {
	            File file = new File(studyAbroadLaw.getFileath());
	            file.delete();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  /*
	   * 
	   * �ļ��ϴ�
	   * */
	  public String uploadFile(MultipartFile file) throws Exception {
		 
	        //ָ�������ļ��д洢ͼƬ
	        String uploadPath =DetailUtil.getUrl()+"src/main/resources/static/txt/";
	        String filename = file.getName();
	        System.out.println("�ϴ��ļ������ƣ�"+filename);

	        //��ȡ�ļ��ĺ�׺��
	        String suffixName = file.getOriginalFilename();
	        System.out.println(suffixName);
	        //��׺����
	        String a[] = suffixName.split(".");
	        for(int i=0;i<a.length;i++){
	            System.out.println(a[i]);
	        }
	       
	        System.out.println(suffixName.substring(suffixName.indexOf(".")));

	        filename = UUID.randomUUID()+suffixName.substring(suffixName.indexOf("."));
	        System.out.println(filename);
	        System.out.println(uploadPath+filename);
	        File newFile = new File(uploadPath+filename); 
	        try {
	            file.transferTo(newFile);  //�����ļ������ܸ�Ч����ԭ�ȵķ���
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return filename;
	    }
}
