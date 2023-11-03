package liuyang.update11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * try-catch 演进
 *
 * https://www.bilibili.com/video/BV1PY411e7J6?p=198&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 10:00开始
 *
 * @author xconf
 * @since 2023/11/3
 */
@Slf4j
public class TryCatchJDK6Test {
    @DisplayName("JDK6及之前的try-catch写法")
    @Test
    void test01FiltWriter() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("D:\\test.txt");
            fw.write("hello world");
        } catch (Exception e) {
            log.error("write file error", e);
        } finally {
            if (fw!= null) {
                try {
                    fw.close();
                } catch (Exception e) {
                    log.error("close file error", e);
                }
            }
        }
    }

    @DisplayName("JDK6及之前的try-catch写法")
    @Test
    void test02FileReader() {
        FileReader fr = null;
        try {
            fr = new FileReader("D:\\test.txt");
            char[] cbuf = new char[1024];
            int len = 0;
            while ((len = fr.read(cbuf))!= -1) {
                log.info(new String(cbuf, 0, len));
            }
        } catch (Exception e) {
            log.error("read file error", e);
        } finally {
            if (fr!= null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
