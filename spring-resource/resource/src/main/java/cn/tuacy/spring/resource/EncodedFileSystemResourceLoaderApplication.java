package cn.tuacy.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link org.springframework.core.io.FileSystemResourceLoader} 实例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/5 9:14
 */
public class EncodedFileSystemResourceLoaderApplication {

    public static void main(String[] args) throws IOException {
        String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/spring-resource/resource" + "/src/main/java/cn/tuacy/spring/resource/EncodedFileSystemResourceApplication.java";

        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();

        Resource resource = resourceLoader.getResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        // 字符输入流
        try (Reader reader = encodedResource.getReader()) {
            System.out.println(IOUtils.toString(reader));
        }

    }

}
