package cn.tuacy.spring.bean.scope;

import cn.tuacy.spring.bean.scope.entity.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.jws.soap.SOAPBinding;

/**
 * Bean的作用域
 * @author wuyx
 * @version 1.0
 * @date 2020/8/15 23:14
 */
public class BeanScopeApplication {

    @Bean
    // 默认就是 @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class (配置类) -> Spring Bean
        applicationContext.register(BeanScopeApplication.class);

        // 启动Spring应用上下文
        applicationContext.refresh();

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
