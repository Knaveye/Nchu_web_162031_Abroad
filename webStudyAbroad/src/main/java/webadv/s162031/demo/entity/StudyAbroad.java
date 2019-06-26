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


    private Date time;

    private String title;

    private String content;

    private Schoolmanage  schoolmanage;

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
    @ManyToOne
    @JoinColumn(name = "schmanageid")
    public Schoolmanage getSchoolmanage() {
        return schoolmanage;
    }

    public void setSchoolmanage(Schoolmanage schoolmanage) {
        this.schoolmanage = schoolmanage;
    }



}
 