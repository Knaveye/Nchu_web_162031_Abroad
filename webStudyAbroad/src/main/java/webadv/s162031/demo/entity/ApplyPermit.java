package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * 留学申请审核表
 */
@Entity
@Table(name = "applypermit")
public class ApplyPermit {
    private long id;

    private Schoolmanage schoolmanage;

    private StudyApply studyApply;

    private int progress;

    /**
     * 留学审核主键自增长
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permit_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 学校管理员主键
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "schmanage_id")
    public Schoolmanage getSchoolmanage() {
        return schoolmanage;
    }

    public void setSchoolmanage(Schoolmanage schoolmanage) {
        this.schoolmanage = schoolmanage;
    }

    /**
     * 留学申请表主键
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "stdapp_id")
    public StudyApply getStudyApply() {
        return studyApply;
    }

    public void setStudyApply(StudyApply studyApply) {
        this.studyApply = studyApply;
    }

    /**
     * 留学审核进度
     * @return
     */
    @Column(name = "permit_progress")
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
