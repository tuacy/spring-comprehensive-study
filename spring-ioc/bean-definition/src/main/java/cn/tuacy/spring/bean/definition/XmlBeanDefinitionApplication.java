package cn.tuacy.spring.bean.definition;

import cn.tuacy.spring.bean.definition.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于XML配置Bean(XML文件里面配置bean信息)
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/17 19:19.
 */
public class XmlBeanDefinitionApplication {

    public static void main(String[] args) {

        // 创建BeanFactory容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/xml-bean-definition.xml");

        // 获取bean
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person.toString());

        applicationContext.close();

    }

}
