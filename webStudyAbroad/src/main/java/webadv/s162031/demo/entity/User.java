package webadv.s162031.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yjp
 * @date:
 * @description:
 * �û�
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
     * �û�id��������
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
     * �û��˻�
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
     * �û�����
     * @return
     */
    @Column(name = "userpassword")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * �û�����
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
     * �û�����
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
     * ��������
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
     * �û�����
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
