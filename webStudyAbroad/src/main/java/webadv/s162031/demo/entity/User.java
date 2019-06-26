package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * 用户
 */
@Entity
public class User {
    private long id;

    private String account;

    private String password;

    private String name;


    private String passport;

    private Date birth;

    private String email;

    /**
     * 用户id，自增长
     * @return
     */
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "userid")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 用户账户
     * @return
     */
    @Column(name = "useraccount")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 用户密码
     * @return
     */
    @Column(name = "userpassword",unique = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户名字
     * @return
     */
    @Column(name = "username")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 用户护照
     * @return
     */
    @Column(name = "passport")
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * 出生年月
     * @return
     */
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 用户邮箱
     * @return
     */
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
