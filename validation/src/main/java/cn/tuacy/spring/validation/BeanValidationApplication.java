package cn.tuacy.spring.validation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * Spring Bean Validation 整合示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 11:28
 * @see org.springframework.validation.Validator
 * @see org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
 */
public class BeanValidationApplication {

    public static void main(String[] args) {

        // 配置XML配置文件
        // 启动Spring应用上下文
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/bean-validation-context.xml");

//        Validator validator = applicationContext.getBean(Validator.class);
//        System.out.println(validator instanceof LocalValidatorFactoryBean);

        UserProcessor userProcessor = applicationContext.getBean(UserProcessor.class);
        userProcessor.process(new User());

        // 关闭应用上下文
        applicationContext.close();

    }

    @Component
    @Validated
    static class UserProcessor {
        public void process(@Valid User user) {
            System.out.println(user);
        }
    }

    static class User {
        @NotNull
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
