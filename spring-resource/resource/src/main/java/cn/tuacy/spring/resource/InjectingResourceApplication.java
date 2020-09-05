package cn.tuacy.spring.resource;

import cn.tuacy.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * 注入 {@link org.springframework.core.io.Resource} 对象实例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/5 15:05
 *
 * @see org.springframework.core.io.Resource
 * @see org.springframework.beans.factory.annotation.Value
 * @see org.springframework.context.annotation.AnnotationConfigApplicationContext
 */
public class InjectingResourceApplication {

    @Value("classpath:/META-INF/default.properties")
    private Resource defaultPropertiesResource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] propertiesResources;

    @Value("${user.dir}")
    private String currentProjectRootPath;

    @PostConstruct
    public void init() {
        System.out.println(ResourceUtils.getContent(defaultPropertiesResource));
        System.out.println("=======================");
        Stream.of(propertiesResources).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("=======================");
        System.out.println(currentProjectRootPath);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为Configuration Class
        context.register(InjectingResourceApplication.class);
        // 启动Spring应用上下文
        context.refresh();
        // 关闭Spring应用上下文
        context.close();
    }

}
