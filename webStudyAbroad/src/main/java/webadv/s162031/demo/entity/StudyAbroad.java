package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * ��ѧ��̬
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
     * ��ѧ��̬id��������
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
     * �û�������
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
     * ����ʱ��
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
     * ��������
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
     * ��������
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
