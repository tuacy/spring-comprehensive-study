package cn.tuacy.spring.conversion.entity;

import sun.dc.pr.PRError;

import java.util.Properties;

/**
 * @author wuyx
 * @version 1.0
 * @date 2020/9/13 13:52
 */
public class User {
    private Long id;
    private String name;
    private Properties context;
    private String contextAsText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Properties getContext() {
        return context;
    }

    public void setContext(Properties context) {
        this.context = context;
    }

    public String getContextAsText() {
        return contextAsText;
    }

    public void setContextAsText(String contextAsText) {
        this.contextAsText = contextAsText;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", context=" + context +
                ", contextAsText='" + contextAsText + '\'' +
                '}';
    }
}
