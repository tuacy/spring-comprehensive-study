package cn.tuacy.spring.validation;

import cn.tuacy.spring.validation.entity.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Locale;

import static cn.tuacy.spring.validation.ErrorsMessageApplication.createMessageSource;

/**
 * 自定义{@link org.springframework.validation.Validator}示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 11:13
 */
public class ValidatorApplication {

    public static void main(String[] args) {
        // 1. 创建 Validator
        Validator validator = new UserValidator();
        // 2. 判断 是否支持目标对象的类型
        User user = new User();
        System.out.println("user对象是否被UserValidator支持检验：" + validator.supports(user.getClass()));
        // 3. 创建Errors对象
        Errors errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors);

        // 4. 获取MessageSource对象
        MessageSource messageSource = createMessageSource();

        // 5. 输出所有的错误文案
        for (ObjectError error: errors.getAllErrors()) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    static class UserValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        }
    }




}
