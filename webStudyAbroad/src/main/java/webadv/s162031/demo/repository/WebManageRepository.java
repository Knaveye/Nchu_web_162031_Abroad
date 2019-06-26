package webadv.s162031.demo.repository;

import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.entity.WebManage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebManageRepository extends JpaRepository<WebManage,Long> {
    WebManage findByAccountAndPassword(String account, String password);
}
