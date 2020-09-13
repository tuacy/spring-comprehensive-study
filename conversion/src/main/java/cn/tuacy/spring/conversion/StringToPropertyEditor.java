package cn.tuacy.spring.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * String -> Properties{@link Properties}
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/13 13:30
 */
public class StringToPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    // 1. 实现setAsText方法
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // 2. 将String类型转换为Properties类型
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        // 3. 临时存储Properties对象
        setValue(properties);
    }
}
