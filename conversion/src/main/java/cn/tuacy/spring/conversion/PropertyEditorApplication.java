package cn.tuacy.spring.conversion;

import java.beans.PropertyEditor;

/**
 * {@link java.beans.PropertyEditor} 示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/13 13:29
 * @see PropertyEditor
 */
public class PropertyEditorApplication {
    public static void main(String[] args) {

        // 模拟 Spring Framework操作
        // 有一段文档本 name = tuacy
        String text = "name = tuacy";
        PropertyEditor propertyEditor = new StringToPropertyEditor();
        // 传递String类型的内容
        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue());

    }
}
