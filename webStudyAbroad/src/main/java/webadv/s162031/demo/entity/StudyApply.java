package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * 留学申请表
 */
@Entity
@Table(name = "apply")
public class StudyApply {
    private long id;

    private School school;

    private User user;

    private String context;

    private String describe;

    /**
     * 主键自增长
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applyid")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 学校id
     * @return
     */
    @ManyToOne
@JoinColumn(name = "schoolid")
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToOne
    @JoinColumn(name = "userid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "apply_context")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
@Column(name = "apply_describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
