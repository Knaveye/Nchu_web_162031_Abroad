package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * ѧУ����Ա
 */
@Entity
@Table(name = "schoolmanage")
public class Schoolmanage {

    private long id;

    private String account;

    private String passward;

    /**
     * ѧУ����Աid��������
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schmanageid")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * ѧУ����Ա�˺�
     * @return
     */
    @Column(name = "schmanageAccount")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * ѧУ����Ա����
     * @return
     */
    @Column(name = "schmanagePassword")
    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    /**
     * ����Ա����ѧУ
     * @return
     */
    @ManyToOne
@JoinColumn(name = "schoolId")
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    private School school;
}
