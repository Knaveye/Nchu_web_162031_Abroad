package webadv.s162031.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import webadv.s162031.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByAccountAndPassword(String account, String password);
}
