package cn.tuacy.spring.bean.definition;

import cn.tuacy.spring.bean.definition.service.LogicService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用注解定义Bean(@Component, @Service等)
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/17 19:32.
 */
public class AnnotationBeanDefinitionApplication {

    private static final boolean XML = false;

    public static void main(String[] args) {
        if (!XML) {
            // 创建BeanFactory容器
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
            // 设置扫描路径
            applicationContext.scan("cn.tuacy.spring.bean.definition");
            applicationContext.refresh();

            LogicService logicService = applicationContext.getBean("logicService", LogicService.class);
            System.out.println(logicService.toString());

            applicationContext.close();

        } else {
            // 创建BeanFactory容器
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/annotation-bean-definition.xml");

            LogicService logicService = applicationContext.getBean("logicService", LogicService.class);
            System.out.println(logicService.toString());

            applicationContext.close();
        }

    }

}
