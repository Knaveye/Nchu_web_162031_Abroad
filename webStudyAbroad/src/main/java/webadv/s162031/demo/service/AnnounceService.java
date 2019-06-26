package webadv.s162031.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webadv.s162031.demo.DetailUtil;
import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.StudyAnnounce;
import webadv.s162031.demo.repository.StudyAnnounceRepository;

@Service
public class AnnounceService {
    @Autowired
    StudyAnnounceRepository studyAnnounceRepository;
    
    
    public List<StudyAnnounce> findAllAnnounce(){
    	List<StudyAnnounce> list=studyAnnounceRepository.findAll();
    	return list;	
    }
    
    public StudyAnnounce findStudyAnnounceById(Long id) {
    	
    	StudyAnnounce studyAnnounce=studyAnnounceRepository.getOne(id);
    	return studyAnnounce;
		
	}
    public List<StudyAnnounce> findAllBySchamnage(Schoolmanage schoolmanage) {
		return studyAnnounceRepository.findAllBySchoolmanage(schoolmanage);
	}
    
    public List<StudyAnnounce> top4list() {//��ѯǰ������¼
  	  Sort sort=new Sort(Sort.Direction.DESC, "time");
  	  int count=(int) studyAnnounceRepository.count();
  	  List<StudyAnnounce> list2=null;
  	  if(count<4) {
  		  list2=studyAnnounceRepository.findAll(sort);
  	  }else {
  		  List<StudyAnnounce> list=studyAnnounceRepository.findAll(sort);
  			 list2=list.subList(0, 3);
  	  }
  	
  	return list2;
  }
    
    public String addAnnounce(StudyAnnounce studyAnnounce) {//��ӹ���涨
    	studyAnnounceRepository.save(studyAnnounce);
    	if(studyAnnounceRepository.existsById(studyAnnounce.getId())) {
    		return "��ӳɹ�";
    	}else {
    		return "���ʧ��";
    	}
    	
    }
    public String deleteAnnounce(Long id) {//ɾ������涨
    	studyAnnounceRepository.deleteById(id);
    	delfile(id);
    	if(studyAnnounceRepository.existsById(id)) {
    		return "ɾ��ʧ��";
    	}else {
    		return "ɾ���ɹ�";
    	}
	}
    
    /*
	   * ɾ�������ļ�
	   * */
	  public void delfile(Long id){
		   StudyAnnounce studyAnnounce=studyAnnounceRepository.getOne(id);
	        try {
	            File file = new File(studyAnnounce.getFilepath());
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
