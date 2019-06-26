package webadv.s162031.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webadv.s162031.demo.entity.AbroadApply;
import webadv.s162031.demo.entity.School;



/**
 *��ѧ�������ݽӿ���
 *
 * @author ����
 * @since 2019-06-16
 */ 
@Repository
public interface AbroadApplyRepository extends JpaRepository<AbroadApply, Integer>{

     public AbroadApply findAbroadApplyByUserId(long userId);
     
     public List<AbroadApply> findAbroadApplysBySchool(School school);

}
