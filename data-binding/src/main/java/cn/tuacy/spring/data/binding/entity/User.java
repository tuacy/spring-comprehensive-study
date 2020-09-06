package cn.tuacy.spring.data.binding.entity;

/**
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 10:58
 */
public class User {

    private String name;
    private Long id;
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", company=" + company +
                '}';
    }
}
