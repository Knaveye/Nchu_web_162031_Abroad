package webadv.s162031.demo.repository;

import webadv.s162031.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import webadv.s162031.demo.entity.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUser(User user);
    List<Post> findAllByOrderByViewcountDesc();
}
