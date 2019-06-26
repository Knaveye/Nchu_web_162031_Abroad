package webadv.s162031.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import webadv.s162031.demo.entity.Schoolmanage;
import webadv.s162031.demo.entity.StudyAbroad;
import webadv.s162031.demo.repository.StudyAbroadRepository;

@Service
public class NewsService {//新闻服务类news
	@Autowired
	private StudyAbroadRepository newsAbroadRepository;

	public List<StudyAbroad> top5list() {//查询前五条记录
		Sort sort=new Sort(Sort.Direction.DESC, "time");
		int count=(int) newsAbroadRepository.count();
		List<StudyAbroad> list2=null;
		if(count<5) {
			list2=newsAbroadRepository.findAll(sort);
		}else {
			List<StudyAbroad> list=newsAbroadRepository.findAll(sort);
			list2=list.subList(0, 4);
		}

		return list2;
	}
	public List<StudyAbroad> findlistBySchoolManage(Schoolmanage schoolmanage){
		return newsAbroadRepository.findAllBySchoolmanage(schoolmanage);

	}
	public List<StudyAbroad> findAllList() {//查询所有记录
		Sort sort=new Sort(Sort.Direction.DESC, "time");
		List<StudyAbroad> list=newsAbroadRepository.findAll(sort);
		return list;
	}
	public StudyAbroad findOneNews(Long id) {
		StudyAbroad studyAbroad=newsAbroadRepository.getOne(id);
		return studyAbroad;
	}
	public String addnews(StudyAbroad studyAbroad) {//添加动态
		newsAbroadRepository.save(studyAbroad);
		if(newsAbroadRepository.existsById(studyAbroad.getId())) {
			return "添加成功";
		}else {
			return "添加失败";
		}
	}
	public String deletenews(Long id) {//删除动态
		newsAbroadRepository.deleteById(id);
		if(newsAbroadRepository.existsById(id)) {
			return "删除失败";
		}else {
			return "添加成功";
		}
	}
}
