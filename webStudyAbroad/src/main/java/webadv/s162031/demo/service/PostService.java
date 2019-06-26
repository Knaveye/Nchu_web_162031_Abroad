package webadv.s162031.demo.service;

import webadv.s162031.demo.entity.Post;
import webadv.s162031.demo.entity.User;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    void savePost(String ptitle, String pcontext,long id);

    void addViewCount(long id);

    Post findById(long postid);

    List<Post> findAllByUser(User user);

    void deleteById(long postid);

    List<Post> findAllOrderByViewCount();
}
