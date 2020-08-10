package cn.tuacy.spring.dependencies.dependencyinjection;

/**
 *
 * 基于setter的依赖注入对应的bean
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/10 19:53.
 */
public class SetterDependencyInjectionBean {

    private String name;
    private int age;

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
