package cn.tuacy.spring.data.binding;

import cn.tuacy.spring.data.binding.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link org.springframework.validation.DataBinder}示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/6 14:56
 *
 * @see org.springframework.validation.DataBinder
 */
public class DataBinderApplication {

    public static void main(String[] args) {

        // 创建空白对象
        User user = new User();
        // 1. 创建DataBinder
        DataBinder dataBinder = new DataBinder(user, "user");

        // 2. 创建 PropertyValues
        Map<String, Object> source = new HashMap<>();
        source.put("id", 1);
        source.put("name", "tuacy");

        // PropertyValues 存在 User中不存在属性值
        // DataBinder 特性一: 忽略未知属性
        source.put("age", 18);

        // PropertyValues 存在一个嵌套属性
        // DataBinder 特性二: 支持嵌套属性
        source.put("company.name", "pilot");

        PropertyValues propertyValues = new MutablePropertyValues(source);

        dataBinder.bind(propertyValues);

        // 3. 输出user内容
        System.out.println(user);

        // 4. 获取绑定结果(结果包含错误文案 code,不会抛出异常)
        BindingResult result = dataBinder.getBindingResult();
        System.out.println(result);
    }

}
