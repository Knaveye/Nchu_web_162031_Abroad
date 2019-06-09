package webadv.s162031.demo.entity;

import javax.persistence.*;

/**
 * @author: yjp
 * @date:
 * @description:
 * 学校   4
 */
@Entity
public class School {
    private long id;

    private String school_net;

    private String school_name;

    /**
     * 学校id ，自增长
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
     * 学校链接
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
     * 学校名字
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
