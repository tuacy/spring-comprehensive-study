package cn.tuacy.spring.validation;

import cn.tuacy.spring.validation.entity.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * 错误文案示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 10:55
 *
 * @see org.springframework.validation.Errors
 */
public class ErrorsMessageApplication {

    public static void main(String[] args) {
        // 0. 创建User对象
        User user = new User();
        user.setName("tuacy");
        // 1. 选择Errors-BeanPropertyBindingResult的实现
        Errors errors = new BeanPropertyBindingResult(user, "user");
        // 2. 调用reject或rejectValue
        // reject生成ObjectError
        // rejectValue生成FiledError
        errors.reject("user.properties.not.null");
        // user.name = user.getName()
        errors.rejectValue("name", "name.required");

        // 3. 获取Errors中的ObjectError和FiledError
        // FiledError is ObjectError
        List<ObjectError> globalErrors = errors.getGlobalErrors();
        List<FieldError> filedErrors = errors.getFieldErrors();
        List<ObjectError> allErrors = errors.getAllErrors();

        // 4. 通过ObjectError和FiledError中的 code 和 args 来关联 MessageSource 实现
        MessageSource messageSource = createMessageSource();

        for (ObjectError error: allErrors) {
            String message = messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault());
            System.out.println(message);
        }
    }

    static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(), "User属性不能为null.");
        messageSource.addMessage("id.required", Locale.getDefault(), "the id of User must not be null.");
        messageSource.addMessage("name.required", Locale.getDefault(), "the name of User must not be null.");
        return messageSource;
    }

}
