package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * ѧУ   4
 */
@Entity
public class School {
    private long id;

    private String school_net;

    private String school_name;

    /**
     * ѧУid ��������
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schoolid")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * ѧУ����
     * @return
     */
    @Column(name = "schoolnet")
    public String getSchool_net() {
        return school_net;
    }

    public void setSchool_net(String school_net) {
        this.school_net = school_net;
    }

    /**
     * ѧУ����
     * @return
     */
    @Column(name = "schoolname")
    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }


}
