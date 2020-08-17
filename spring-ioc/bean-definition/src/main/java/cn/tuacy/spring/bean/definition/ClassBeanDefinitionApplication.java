package cn.tuacy.spring.bean.definition;

import cn.tuacy.spring.bean.definition.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于Java类配置Bean(@Bean)
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/17 19:44.
 */
public class ClassBeanDefinitionApplication {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ClassBeanDefinitionApplication.class);
        applicationContext.refresh();

        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person.toString());

        applicationContext.close();
    }


    @Bean()
    static Person person() {
        Person person = new Person();
        person.setName("tuacy");
        person.setAge(29);
        return person;
    }

}
