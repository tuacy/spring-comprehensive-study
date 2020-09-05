package cn.tuacy.spring.resource;

import cn.tuacy.spring.resource.util.ResourceUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * 自定义 {@link org.springframework.core.io.support.ResourcePatternResolver} 示例
 *
 * @author wuyx
 * @version 1.0
 * @date 2020/9/5 14:48
 * @see org.springframework.core.io.support.ResourcePatternResolver
 * @see org.springframework.core.io.support.PathMatchingResourcePatternResolver
 * @see java.nio.file.PathMatcher
 */
public class CustomizedResourcePatternResolveApplication {

    public static void main(String[] args) throws IOException {
        // 读取当前package对应的所有.java文件
        // *.java
        String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/spring-resource/resource" + "/src/main/java/cn/tuacy/spring/resource/";
        String locationPattern = currentJavaFilePath + "*.java";
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
//        resourcePatternResolver.setPathMatcher(new JavaFilePathMatcher());
        Resource[] resources = resourcePatternResolver.getResources(locationPattern);
        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);

    }

    static class JavaFilePathMatcher implements PathMatcher {

        @Override
        public boolean isPattern(String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean match(String pattern, String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean matchStart(String pattern, String path) {
            return false;
        }

        @Override
        public String extractPathWithinPattern(String pattern, String path) {
            return null;
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
            return null;
        }

        @Override
        public Comparator<String> getPatternComparator(String path) {
            return null;
        }

        @Override
        public String combine(String pattern1, String pattern2) {
            return null;
        }
    }

}
