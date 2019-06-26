package webadv.s162031.demo.repository;

import webadv.s162031.demo.entity.Schoolmanage;
import org.springframework.data.jpa.repository.JpaRepository;
import webadv.s162031.demo.entity.User;

public interface SchoolmanageRepository extends JpaRepository<Schoolmanage,Long> {
   Schoolmanage  findByAccountAndPassward(String account, String password);
}
