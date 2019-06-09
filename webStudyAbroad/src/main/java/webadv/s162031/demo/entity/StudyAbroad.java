package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * 留学动态
 */
@Entity
@Table(name = "studyAbroad")
public class StudyAbroad {
    private long id;

    private User user;

    private Date time;

    private String title;

    private String content;

    /**
     * 留学动态id，自增长
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sa_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 用户表主键
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "userId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 发布时间
     * @return
     */
    @Column(name = "sa_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 发布标题
     * @return
     */
    @Column(name = "sa_title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 发布内容
     * @return
     */
    @Column(name = "sa_content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
