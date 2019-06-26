package webadv.s162031.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import webadv.s162031.demo.entity.AbroadApply;
import webadv.s162031.demo.entity.AbroadExam;



/**
 *留学审核数据接口类
 *
 * @author 杨磊
 * @since 2019-06-16
 */ 
@Repository
public interface AbroadExamRespository extends JpaRepository< AbroadExam, Integer>{

     public AbroadExam findAbroadExamByAbroadApply(AbroadApply abroadApply);
     

}
