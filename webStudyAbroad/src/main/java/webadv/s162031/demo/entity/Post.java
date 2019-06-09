package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * 帖子
 */
@Entity
@Table(name = "post")
public class Post {

    private long id;

    private String name;

    private User user;


    private long viewcount;



    private Date postdate;

    /**
     * 帖子表的主鍵postid
     * @return
     */
    @Id
@Column(name = "postid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 发帖人id，user表外键
     * @param
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
     * 帖子名称
     * @return
     */
    @Column(name = "postname")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 帖子浏览次数
     * @return
     */
    public long getViewcount() {
        return viewcount;
    }

    public void setViewcount(long viewcount) {
        this.viewcount = viewcount;
    }

    /**
     * 发帖日期
     * @return
     */
    @Temporal(TemporalType.TIME)
    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }
}