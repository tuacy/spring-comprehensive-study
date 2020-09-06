package cn.tuacy.spring.data.binding.entity;

/**
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 15:01
 */
public class Company {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
