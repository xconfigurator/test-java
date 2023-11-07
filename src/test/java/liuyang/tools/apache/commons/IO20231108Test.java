package liuyang.tools.apache.commons;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=4&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * FileUtils
 * FilenameUtils
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class IO20231108Test {
    @DisplayName("读指定文件内容为一个字符串")
    @Test
    void test202311080504() throws IOException {
        String FILE_PATH = "D:\\workspaces_test\\test.txt";
        String s = FileUtils.readFileToString(new File(FILE_PATH), StandardCharsets.UTF_8);
        log.info("{}", s);
    }

    @DisplayName("读取指定文件内容(按行)")
    @Test
    void test202311080602() throws IOException {
        // List<String>
        String FILE_PAHT = "D:\\workspaces_test\\test.txt";
        List<String> strings = FileUtils.readLines(new File(FILE_PAHT), StandardCharsets.UTF_8);
        strings.forEach(System.out::println);

        // LineIterator
        LineIterator lineIterator = FileUtils.lineIterator(new File(FILE_PAHT), "UTF-8");
        while(lineIterator.hasNext()) {
            System.out.println(lineIterator.next());
        }
    }

    @DisplayName("其他小功能")
    @Test
    void test202311080608() {
        // 环境
        log.info("{}", FileUtils.getTempDirectory());
        log.info("{}", FileUtils.getTempDirectoryPath());
        log.info("{}", FileUtils.getUserDirectory());
        log.info("{}", FileUtils.getUserDirectoryPath());

        // 文件名
        String FILE_PATH = "D:\\workspaces_test\\test.txt";
        log.info("{}", FilenameUtils.getBaseName(FILE_PATH));// test
        log.info("{}", FilenameUtils.getExtension(FILE_PATH));// txt
    }
}
