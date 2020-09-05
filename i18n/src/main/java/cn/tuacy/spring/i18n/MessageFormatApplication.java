package cn.tuacy.spring.i18n;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * {@link java.text.MessageFormat} 示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/5 23:30
 */
public class MessageFormatApplication {

    public static void main(String[] args) {
//        int planet = 7;
//        String event = "a disturbance in the Force";
//        String result = MessageFormat.format("At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
//                planet, new Date(), event);
//
//        System.out.println(result);

        int planet = 7;
        String event = "a disturbance in the Force";

        String messageFormatPattern = "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.";
        MessageFormat messageFormat = new MessageFormat(messageFormatPattern);
        String result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);

        // 重置messageFormatPattern
        // applyPattern
        messageFormatPattern = "This is a text:{0},{1},{2}";
        messageFormat.applyPattern(messageFormatPattern);
        result = messageFormat.format(new Object[]{"Hello,World", "666"});
        System.out.println(result);

        // 重置Locale
        messageFormat.setLocale(Locale.ENGLISH);
        messageFormatPattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";
        messageFormat.applyPattern(messageFormatPattern);
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);

        // 重置Format
        // 根据参数索引来这是Pattern
        messageFormat.setFormat(1, new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);


    }

}
