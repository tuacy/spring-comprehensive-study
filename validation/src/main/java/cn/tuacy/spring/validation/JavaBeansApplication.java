package cn.tuacy.spring.validation;

import cn.tuacy.spring.validation.entity.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 15:32
 */
public class JavaBeansApplication {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        // 属性描述符 PropertyDescriptor

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(System.out::println);

        Stream.of(beanInfo.getMethodDescriptors()).forEach(System.out::println);
    }

}
