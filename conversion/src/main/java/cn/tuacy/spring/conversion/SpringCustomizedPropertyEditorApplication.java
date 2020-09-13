package cn.tuacy.spring.conversion;

import cn.tuacy.spring.conversion.entity.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 自定义 {@link java.beans.PropertyEditor} 示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/13 13:55
 */
public class SpringCustomizedPropertyEditorApplication {

    public static void main(String[] args) {
        // 创建并且启动BeanFactory
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/property-eidtors-context.xml");

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        // 关闭应用上下文
        applicationContext.close();
    }

}
