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
@Table(name = "stuayAnnounce")
public class StudyAnnounce {
    private long id;

    private User user;

    private String content;

    private Date time;

    private String title;

    private String filename;

    private  String filepath;

    /**
     * ��ѧ����������������
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ann_id")
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
    @Column(name = "ann_content")
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
    @Column(name = "ann_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * �������
     * @return
     */
    @Column(name = "ann_title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ���渽������
     * @return
     */
    @Column(name = "ann_filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * ���渽��·��
     * @return
     */
    @Column(name = "ann_filepath")
    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
