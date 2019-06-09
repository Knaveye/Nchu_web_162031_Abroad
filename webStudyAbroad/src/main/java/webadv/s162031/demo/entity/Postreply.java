package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * ���ӵĻظ���
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
     * ���ӻظ�
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
     * ���ӱ�������
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
     * user������
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
     * �ظ�ʱ��
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
     * �ظ�����
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
     * ¥��
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
