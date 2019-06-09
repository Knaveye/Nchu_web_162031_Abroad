package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * 帖子的回复表
 */
@Entity
public class Postreply {
    private long id;

    private Post post;

    private User user;

    private Date replayDate;

    private String content;

    private long  floornum;

    /**
     * 帖子回复
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postreplyId")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 帖子表主键，
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "postid")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * user表主键
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "userid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 回复时间
     * @return
     */
    @Column(name = "replayTime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getReplayDate() {
        return replayDate;
    }

    public void setReplayDate(Date replayDate) {
        this.replayDate = replayDate;
    }

    /**
     * 回复内容
     * @return
     */
    @Column(name = "replaycontent")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 楼层
     * @return
     */
    @Column(name = "floornum")
    public long getFloornum() {
        return floornum;
    }

    public void setFloornum(long floornum) {
        this.floornum = floornum;
    }
}
