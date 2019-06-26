package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * 留学法规
 */
@Entity
@Table(name = "studylaw")
public class StudyAbroadLaw {

    private long id;



    private String content;


    private Date time;

    private String title;

    private String filename;

    private String fileath;

    private WebManage webManage;
    /**
     * 留学法规id
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
     * 外键，用户表id
     * @return
     */


    /**
     * 留学法规内容
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
     * 发布时间
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
     * 标题
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
     * 附件名称
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
     * 附件路径
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
    @JoinColumn(name = "webmanageid")
    public WebManage getWebManage() {
        return webManage;
    }

    public void setWebManage(WebManage webManage) {
        this.webManage = webManage;
    }
}
