package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * 网站管理员
 *
 */
@Entity
@Table(name = "webmanage")
public class WebManage {
    private long id;

    private String account;

    private String password;

    /**
     * 网站管理员id，自增长
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "webmanageid")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 网站管理员账户
     * @return
     */
    @Column(name = "webAccount")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 网站管理员密码
     * @return
     */
    @Column(name = "webPassword")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
