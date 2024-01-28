package liuyang.tools.qrcode.zxing;

import liuyang.tools.excel.easyexcel.easyexcel20231228.util.TestFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;

/**
 * 视频参考：
 * https://www.bilibili.com/video/BV1PH4y1U7jt/?spm_id_from=333.999.0.0&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 *
 * 演示工具：
 * zxing
 * 其他可选工具：
 * hutool
 *
 * @author xconf
 * @since 2024/1/19
 */
@Slf4j
public class QRCodeTest {

    @Test
    void testPath() {
        String path = QRCodeTest.class.getResource("/").getPath();
        log.info(path);
        String pathWithoutClass = QRCodeTest.class.getResource("/").getPath().replace("test-classes/", "");
        log.info(pathWithoutClass);
        log.info("{}", TestFileUtil.getPath());
    }

    @DisplayName("写到输入流")
    @Test
    void test202401190411() {
        // 文件名
        String fileName = TestFileUtil.getPath() + "qr_" + System.currentTimeMillis() + ".png";
        log.info("输出文件：{}", fileName);

        // 写入输入流
        try(FileOutputStream fos = new FileOutputStream(fileName)) {
            QrUtil.writeToStream(100, 100, 0, "http://www.roadjava.com", fos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    @DisplayName("写入指定目录")
    @Test
    void test202401190417() {
        // 文件名
        String fileName = TestFileUtil.getPath() + "qr_" + System.currentTimeMillis() + ".png";
        log.info("输出文件：{}", fileName);
        log.info("输出文件（修正）：{}", fileName.replaceFirst("/", ""));

        // 写到指定目录
        QrUtil.writeToPath(100,100, 5, "123abc", fileName.replaceFirst("/", ""));
    }
}
