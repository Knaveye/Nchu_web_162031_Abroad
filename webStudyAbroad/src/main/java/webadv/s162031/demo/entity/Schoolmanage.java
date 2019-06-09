package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * 学校管理员
 */
@Entity
@Table(name = "schoolmanage")
public class Schoolmanage {

    private long id;

    private String account;

    private String passward;

    /**
     * 学校管理员id，自增长
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
     * 学校管理员账号
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
     * 学校管理员密码
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
     * 管理员所属学校
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
