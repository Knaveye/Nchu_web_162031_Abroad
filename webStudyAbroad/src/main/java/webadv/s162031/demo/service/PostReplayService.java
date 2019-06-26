package webadv.s162031.demo.service;

import webadv.s162031.demo.entity.Post;
import webadv.s162031.demo.entity.Postreply;

import java.util.List;

public interface PostReplayService {
    List<Postreply> findAllByPost(Post post);

    void saveUserReplay(String replaynews, long postid, long id);

    void saveSchoolReplay(String replaynews, long postid, long id);

    void saveWebReplay(String replaynews, long postid, long id);
}
