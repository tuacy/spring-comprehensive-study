package cn.tuacy.spring.bean.resolve.register;

import cn.tuacy.spring.bean.resolve.register.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于Java的配置类加载Spring的应用上下文
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/8/17 14:08.
 */
public class AnnotationConfigResolveRegisterApplication {

    public static void main(String[] args) {

        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class (配置类) -> Spring Bean
        applicationContext.register(AnnotationConfigResolveRegisterApplication.class);

        // 启动Spring应用上下文
        applicationContext.refresh();

        User user = applicationContext.getBean("user", User.class);

        // 关闭上下文
        applicationContext.close();
    }

    @Bean
    static User user() {
        User user = new User();
        user.setName("tuacy");
        user.setAge(30);
        return user;
    }

}
