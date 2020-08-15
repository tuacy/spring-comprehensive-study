package cn.tuacy.spring.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置作为依赖来源
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/8/15 8:24
 */
@Configuration
@PropertySource(value = "META-INF/default.properties",encoding="UTF-8")
public class ExternalConfigurationDependencySourceApplication {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${usr.name}")
    private String name;

    @Value("${user.resource:classpath://default.properties}")
    private Resource resource;

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class (配置类) -> Spring Bean
        applicationContext.register(ExternalConfigurationDependencySourceApplication.class);

        // 启动Spring应用上下文
        applicationContext.refresh();

        ExternalConfigurationDependencySourceApplication demo = applicationContext.getBean(ExternalConfigurationDependencySourceApplication.class);
        System.out.println(demo.id);
        System.out.println(demo.name);
        System.out.println(demo.resource);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
