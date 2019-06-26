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
    
    public List<StudyAbroadLaw> findAlLaws() {//查询所有规定
		return studyAbroadLawRepository.findAllRule();
	}
    
    public StudyAbroadLaw findByid(Long id) {
    	StudyAbroadLaw studyAbroadLaw=studyAbroadLawRepository.getOne(id);
		return studyAbroadLaw;
	}
    public List<StudyAbroadLaw> findForeignLaws() {//查询所有国外管理规定
		return studyAbroadLawRepository.findAllForeignRule();
	}
    public String addRule(StudyAbroadLaw studyAbroadLaw) {//添加管理规定
    	studyAbroadLawRepository.save(studyAbroadLaw);
    	if(studyAbroadLawRepository.existsById(studyAbroadLaw.getId())) {
    		return "添加成功";
    	}else {
    		return "添加失败";
    	}
    	
    }
    public String deleteRule(Long id) {//删除管理规定
    	studyAbroadLawRepository.deleteById(id);
    	delfile(id);
    	if(studyAbroadLawRepository.existsById(id)) {
    		return "删除失败";
    	}else {
    		return "删除成功";
    	}
	}
    
    /*
	   * 删除规定文件
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
	   * 文件上传
	   * */
	  public String uploadFile(MultipartFile file) throws Exception {
		 
	        //指定本地文件夹存储图片
	        String uploadPath =DetailUtil.getUrl()+"src/main/resources/static/txt/";
	        String filename = file.getName();
	        System.out.println("上传文件的名称："+filename);

	        //获取文件的后缀名
	        String suffixName = file.getOriginalFilename();
	        System.out.println(suffixName);
	        //后缀名称
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
	            file.transferTo(newFile);  //拷贝文件，性能高效，比原先的方便
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return filename;
	    }
}
