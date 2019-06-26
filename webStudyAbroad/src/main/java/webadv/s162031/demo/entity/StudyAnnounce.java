package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * 留学公告
 */
@Entity
@Table(name = "studyAnnounce")
public class StudyAnnounce {
    private long id;


    private String content;

    private Date time;

    private String title;

    private String filename;

    private  String filepath;

    private Schoolmanage schoolmanage;

    /**
     * 留学公告主键，自增长
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
     * 公告内容
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
     * 发布时间
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
     * 公告标题
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
     * 公告附件名字
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
     * 公告附件路径
     * @return
     */
    @Column(name = "ann_filepath")
    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    /**
     * 用户表主键
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "schmanageid")
    public Schoolmanage getSchoolmanage() {
        return schoolmanage;
    }

    public void setSchoolmanage(Schoolmanage schoolmanage) {
        this.schoolmanage = schoolmanage;
    }


}
