package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * ��վ����Ա
 *
 */
@Entity
@Table(name = "webmanage")
public class WebManage {
    private long id;

    private String account;

    private String password;

    private String name;

    /**
     * ��վ����Աid��������
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
     * ��վ����Ա�˻�
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
     * ��վ����Ա����
     * @return
     */
    @Column(name = "webPassword")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ����Ա����
     * @return
     */
    @Column(name = "webname")
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
