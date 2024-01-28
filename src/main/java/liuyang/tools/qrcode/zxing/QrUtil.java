package liuyang.tools.qrcode.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xconf
 * @since 2024/1/19
 */
@Slf4j
public class QrUtil {

    /**
     * 生成二维码并保存早指定路径中
     *
     * @param width         二维码图片的宽度，单位：px
     * @param height        二维码图片的高度，单位：px
     * @param margin        二维码图片的留白，单位：px
     * @param content       内容，如果以http开头，扫码后会自动跳转
     * @param imageAbsPath  二维码存放的绝对路径
     */
    public static void writeToPath(int width, int height, int margin, String content, String imageAbsPath) {
        try {
            BitMatrix bitMatrix = buildBitMatrix(width, height, margin, content);
            // 把二维码写到磁盘
            Path path = FileSystems.getDefault().getPath(imageAbsPath);
            // 写入到指定路径
            MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 生成二维码并保存早输出流径中
     *
     * @param width         二维码图片的宽度，单位：px
     * @param height        二维码图片的高度，单位：px
     * @param margin        二维码图片的留白，单位：px
     * @param content       内容，如果以http开头，扫码后会自动跳转
     * @param os            输出流
     */
    public static void writeToStream(int width, int height, int margin, String content, OutputStream os) {
        try {
            BitMatrix bitMatrix = buildBitMatrix(width, height, margin, content);
            // 把二维码写到磁盘
            //Path path = FileSystems.getDefault().getPath(imageAbsPath);
            // 写入到指定路径
            MatrixToImageWriter.writeToStream(bitMatrix, "png", os);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 生成二维码并保存早输出流径中
     *
     * @param width         二维码图片的宽度，单位：px
     * @param height        二维码图片的高度，单位：px
     * @param margin        二维码图片的留白，单位：px
     * @param content       内容，如果以http开头，扫码后会自动跳转
     * @return
     */
    private static BitMatrix buildBitMatrix(int width, int height, int margin, String content) throws WriterException {
        Map<EncodeHintType, Object> encodeHints = new HashMap<>();
        // 内容编码
        encodeHints.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());
        // 设置空白区域大小
        encodeHints.put(EncodeHintType.MARGIN, margin);
        // 设置纠错级别
        encodeHints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 多种格式条形码Writer的工厂类
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, encodeHints);
        return bitMatrix;
    }
}
