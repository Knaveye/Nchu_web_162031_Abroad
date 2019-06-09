package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * ��ѧ����
 */
@Entity
@Table(name = "studylaw")
public class StudyAbroadLaw {

    private long id;

    private User user;

    private String content;


    private Date time;

    private String title;

    private String filename;

    private String fileath;

    /**
     * ��ѧ����id
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sra_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * ������û���id
     * @return
     */


    /**
     * ��ѧ��������
     * @return
     */
    @Column(name = "sra_content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ����ʱ��
     * @return
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sra_time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * ����
     * @return
     */
    @Column(name = "sra_title")
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
    @Column(name = "sra_filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * ����·��
     * @return
     */
    @Column(name = "sra_filepath")
    public String getFileath() {
        return fileath;
    }

    public void setFileath(String fileath) {
        this.fileath = fileath;
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
