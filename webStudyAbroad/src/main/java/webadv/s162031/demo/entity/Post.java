package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * ����
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
     * ���ӱ�����Ipostid
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
     * ������id��user�����
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
     * ��������
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
     * �����������
     * @return
     */
    public long getViewcount() {
        return viewcount;
    }

    public void setViewcount(long viewcount) {
        this.viewcount = viewcount;
    }

    /**
     * ��������
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