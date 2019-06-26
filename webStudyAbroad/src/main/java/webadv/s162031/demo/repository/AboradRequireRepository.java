package webadv.s162031.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webadv.s162031.demo.entity.AbroadRequire;
import webadv.s162031.demo.entity.School;



/**
 *留学审核数据接口类
 *
 * @author 杨磊
 * @since 2019-06-16
 */ 
@Repository
public interface AboradRequireRepository extends JpaRepository<AbroadRequire, Integer>{
 
	 public AbroadRequire findAboradRequireBySchool(School school);


}
