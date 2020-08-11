package cn.tuacy.spring.dependencies.dependencyinjection;

import cn.tuacy.spring.dependencies.entity.BeanConstructorDependencyInjection;
import cn.tuacy.spring.dependencies.entity.BeanSetterDependencyInjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/10 19:41.
 */
public class DependencyInjectionApplication {

    public static void main(String[] args) {

        // 加载 beans 配置文件 -> (ApplicationContext 就相当于是 IoC 容器)
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dependency-injection.xml");

        // 获取bean -- 通过构造器注入的bean
        BeanConstructorDependencyInjection constructorDependencyInjectBean = context.getBean("beanConstructorDependencyInjection", BeanConstructorDependencyInjection.class);
        System.out.println(constructorDependencyInjectBean);

        // 获取bean -> 通过setter注入的bean(也叫属性注入)
        BeanSetterDependencyInjection setterDependencyInjectBean = context.getBean("beanSetterDependencyInjection", BeanSetterDependencyInjection.class);
        System.out.println(setterDependencyInjectBean);

    }

}
