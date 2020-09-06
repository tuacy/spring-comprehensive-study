package cn.tuacy.spring.validation.entity;

/**
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 10:58
 */
public class User {

    private String name;
    private Long id;

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
}
