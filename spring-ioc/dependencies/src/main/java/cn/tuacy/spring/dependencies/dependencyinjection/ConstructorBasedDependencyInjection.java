package cn.tuacy.spring.dependencies.dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于构造函数的依赖注入
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/10 19:41.
 */
public class ConstructorBasedDependencyInjection {

    public static void main(String[] args) {

        // 加载 beans 配置文件 -> (ApplicationContext 就相当于是 IoC 容器)
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dependency-injection.xml");

        // 获取bean
        ConstructorDependencyInjectionBean bean = context.getBean("constructorDependencyInjectionBean", ConstructorDependencyInjectionBean.class);

        System.out.println(bean);
    }

}
