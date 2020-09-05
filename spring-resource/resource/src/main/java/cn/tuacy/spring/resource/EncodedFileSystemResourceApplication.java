package cn.tuacy.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 *
 * 带有字符编码的 {@link FileSystemResource} 实例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/5 9:14
 */
public class EncodedFileSystemResourceApplication {

    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = System.getProperty("user.dir") + "/spring-resource/resource" + "/src/main/java/cn/tuacy/spring/resource/EncodedFileSystemResourceApplication.java";
        FileSystemResource fileSystemResource = new FileSystemResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        // 字符输入流
        Reader reader = encodedResource.getReader();
        System.out.println(IOUtils.toString(reader));
    }

}
