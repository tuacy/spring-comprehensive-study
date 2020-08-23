package cn.tuacy.spring.bean.configuration.metadata;

import cn.tuacy.spring.bean.configuration.metadata.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ObjectUtils;

/**
 * Bean 配置元信息实例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/8/23 16:49
 */
public class BeanConfigurationMetadataApplication {

    public static void main(String[] args) {

        // BeanDefinition 的定义(声明)
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "tuacy");
        // 获取AbstractBeanDefinition
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 附加属性(不影响Bean populate, initialize)
        beanDefinition.setAttribute("name", "老吴");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if(ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    // 属性(存储)上下文
                    String name = (String) bd.getAttribute("name"); // 老吴
                    User user = (User) bean;
                    user.setName(name);
                }
                return bean;
            }
        });

        // 注冊User的BeanDefinition
        beanFactory.registerBeanDefinition("user", beanDefinition);

        User user = beanFactory.getBean("user", User.class);

        System.out.println(user);

    }

}
