package cn.miao.domain;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-14 16:15
 **/
public class User {
    private Integer id;
    private String name;
    private String into;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInto() {
        return into;
    }

    public void setInto(String into) {
        this.into = into;
    }

    public User(Integer id, String name, String into) {
        this.id = id;
        this.name = name;
        this.into = into;
    }

    public User() {
    }
}
