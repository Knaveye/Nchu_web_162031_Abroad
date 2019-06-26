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

    private String name;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String sCountry;
    private String sType;
    private String sEnlishName;
    private String sAddress;
    private String sTitle;

    public String getsCountry() {
        return sCountry;
    }

    public void setsCountry(String sCountry) {
        this.sCountry = sCountry;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getsEnlishName() {
        return sEnlishName;
    }

    public void setsEnlishName(String sEnlishName) {
        this.sEnlishName = sEnlishName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }
}
