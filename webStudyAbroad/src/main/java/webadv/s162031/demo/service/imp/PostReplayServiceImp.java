package webadv.s162031.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webadv.s162031.demo.entity.*;
import webadv.s162031.demo.repository.PostreplyRepository;
import webadv.s162031.demo.repository.SchoolmanageRepository;
import webadv.s162031.demo.repository.WebManageRepository;
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
public class PostReplayServiceImp implements PostReplayService {
    @Autowired
    PostreplyRepository postreplyRepository;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;
    @Autowired
    SchoolmanageRepository schoolmanageRepository;
    @Autowired
    WebManageRepository webManageRepository;
    @Override
    public List<Postreply> findAllByPost(Post post) {
        return postreplyRepository.findAllByPost(post);
    }


    @Override
    public void saveUserReplay(String replaynews, long postid, long id) {
        User user = userService.findById(id);
        Post post = postService.findById(postid);

        List<Postreply> postreplyList = postreplyRepository.findAllByPost(post);
        long floor =0;
        if(!postreplyList.isEmpty()){
            Postreply lastPostreplay = postreplyList.get(postreplyList.size()-1);
            floor = lastPostreplay.getFloornum();
        }
        Postreply postreply =new Postreply();

        postreply.setContent(replaynews);
        postreply.setPost(post);
        postreply.setReplayDate(new Timestamp(System.currentTimeMillis()));
        postreply.setUser(user);

        postreply.setFloornum(floor+1);
        postreplyRepository.save(postreply);
    }

    @Override
    public void saveSchoolReplay(String replaynews, long postid, long id) {
        Schoolmanage schoolmanage = schoolmanageRepository.findById(id).orElse(null);
        Post post = postService.findById(postid);

        List<Postreply> postreplyList = postreplyRepository.findAllByPost(post);

        long floor =0;
        if(!postreplyList.isEmpty()){
            Postreply lastPostreplay = postreplyList.get(postreplyList.size()-1);
            floor = lastPostreplay.getFloornum();
        }
        Postreply postreply =new Postreply();

        postreply.setContent(replaynews);
        postreply.setPost(post);
        postreply.setReplayDate(new Timestamp(System.currentTimeMillis()));

        postreply.setSchoolmanage(schoolmanage);
        postreply.setFloornum(floor+1);
        postreplyRepository.save(postreply);
    }

    @Override
    public void saveWebReplay(String replaynews, long postid, long id) {
        WebManage webManage = webManageRepository.findById(id).orElse(null);
        Post post = postService.findById(postid);

        List<Postreply> postreplyList = postreplyRepository.findAllByPost(post);

        long floor =0;
        if(!postreplyList.isEmpty()){
            Postreply lastPostreplay = postreplyList.get(postreplyList.size()-1);
            floor = lastPostreplay.getFloornum();
        }
        Postreply postreply =new Postreply();

        postreply.setContent(replaynews);
        postreply.setPost(post);
        postreply.setReplayDate(new Timestamp(System.currentTimeMillis()));

        postreply.setWebManage(webManage);
        postreply.setFloornum(floor+1);
        postreplyRepository.save(postreply);
    }
}
