package webadv.s162031.demo.repository;

import webadv.s162031.demo.entity.Post;
import webadv.s162031.demo.entity.Postreply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostreplyRepository extends JpaRepository<Postreply,Long> {
    List<Postreply> findAllByPost(Post post);

}
