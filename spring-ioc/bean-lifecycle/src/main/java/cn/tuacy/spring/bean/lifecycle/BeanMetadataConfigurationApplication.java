package cn.tuacy.spring.bean.lifecycle;

import cn.tuacy.spring.bean.lifecycle.entity.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * Bean 元信息配置示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/8/16 9:28
 */
public class BeanMetadataConfigurationApplication {

    /**
     * Properties资源配置
     */
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 实例化基于 properties 资源 BeanDefinitionReader
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "META-INFO/user.properties";
        // 加载 properties 资源
        Resource resource = new ClassPathResource(location);
        // 指定 UTF-8
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("加载的 BeanDefinition 的数量：" + beanNumbers);
        // 通过 Bean Id和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }

}
