package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * ��ѧ����
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
 * ��ѧ����id
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
     *ѧУ����
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
/**
 * �û�����
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
 * �������ϴ�����
 * @return
 */
    @Column(name = "apply_context")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
   /**
    * �������������� 
    * @return
    */
@Column(name = "apply_describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
