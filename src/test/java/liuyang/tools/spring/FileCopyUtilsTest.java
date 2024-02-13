package liuyang.tools.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * https://www.bilibili.com/video/BV1Lv411P7Ua/?p=10&spm_id_from=pageDriver&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 18:46
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/FileCopyUtils.html
 *
 * @author xconf
 * @since 2023/11/8
 */
@Slf4j
public class FileCopyUtilsTest {

    @Test
    void testFileCopyUtils01() throws IOException {
        File in = new File("D:\\workspaces_test\\test.txt");
        File out = new File("D:\\workspaces_test\\test_by_file_copy_utils.txt");
        FileCopyUtils.copy(in, out);
    }

    @Test
    void testFileCopyUtils02() throws IOException {
        // 源
        ClassPathResource incpr = new ClassPathResource("file/file_copy_in.txt");// 类路径下资源
        EncodedResource iner = new EncodedResource(incpr, StandardCharsets.UTF_8);// 若有编码问题可使用包装类
        // 目标
        File outfile = new File("D:\\workspaces_test\\file_copy_out.txt");
        FileOutputStream outfos = new FileOutputStream(outfile);

        FileCopyUtils.copy(iner.getInputStream(), outfos);
    }


}
