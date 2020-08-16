package cn.tuacy.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * BeanDefinition 合并示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/8/16 10:16
 */
public class MergedBeanDefinitionApplication {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 基于 XML 资源 BeanDefinitionReader 实现
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INFO/merged-bean-definition.xml";
        beanDefinitionReader.loadBeanDefinitions(location);
    }

}
