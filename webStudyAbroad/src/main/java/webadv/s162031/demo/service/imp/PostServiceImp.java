package webadv.s162031.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webadv.s162031.demo.entity.Post;
import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.repository.PostRepository;
import webadv.s162031.demo.service.PostReplayService;
import webadv.s162031.demo.service.PostService;
import webadv.s162031.demo.service.UserService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: yjp
 * @date:
 * @description:
 */
@Service
public class PostServiceImp implements PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;
    @Autowired
    PostReplayService postReplayService;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void savePost(String ptitle, String pcontext,long id) {
        User user = userService.findById(id);
        Post post = new Post();
        post.setName(ptitle);
        //当前时间
        post.setPostdate(new Timestamp(System.currentTimeMillis()));
        post.setPostcontext(pcontext);
        post.setUser(user);
        post.setViewcount(1);
        postRepository.save(post);
    }

    @Override
    public void addViewCount(long id) {
        Post post = postRepository.findById(id).orElse(null);
        long m = post.getViewcount();
        post.setViewcount(m+1);
        postRepository.save(post);
    }

    @Override
    public Post findById(long postid) {
        return postRepository.findById(postid).orElse(null);
    }

    @Override
    public List<Post> findAllByUser(User user) {
        return postRepository.findAllByUser(user);
    }

    @Override
    public void deleteById(long postid) {
        postRepository.deleteById(postid);
    }

    @Override
    public List<Post> findAllOrderByViewCount() {
        return postRepository.findAllByOrderByViewcountDesc();
    }
}
