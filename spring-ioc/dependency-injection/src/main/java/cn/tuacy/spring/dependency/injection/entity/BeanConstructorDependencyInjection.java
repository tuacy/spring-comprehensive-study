package cn.tuacy.spring.dependency.injection.entity;

/**
 *
 * 基于构造函数的依赖注入对应的bean
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/10 19:53.
 */
public class BeanConstructorDependencyInjection {

    private String name;
    private int age;

    public BeanConstructorDependencyInjection(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
