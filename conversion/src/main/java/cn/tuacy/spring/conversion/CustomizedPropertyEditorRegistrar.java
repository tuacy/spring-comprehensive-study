package cn.tuacy.spring.conversion;

import cn.tuacy.spring.conversion.entity.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

/**
 * 自定义 {@link PropertyEditorRegistrar} 实现
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/13 13:50
 *
 * @see PropertyEditorRegistrar
 */
@Component // 3. 将其声明为Spring Bean
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // 1. 通用类型转换
        // 2. Java Bean 属性类型转换

        registry.registerCustomEditor(User.class, "context", new StringToPropertyEditor());

    }
}
