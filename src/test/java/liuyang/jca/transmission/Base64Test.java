package liuyang.jca.transmission;

import org.bouncycastle.util.encoders.Base64;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * JDK曾经也提供了实现，在sun.misc(rt.jar), 但在JDK 11后去除（估计是在JDK 9换JDK包结构的时候去掉的）。
 *
 * @since liuyang
 * @since 2022/2/15
 */
public class Base64Test {

    //public static final String src = "foo";
    public static final String src = "imooc security base64";
    public static final String ENCODING = "UTF-8";

    @Test
    void base64BCEncode() throws UnsupportedEncodingException {
        byte[] encode = Base64.encode(src.getBytes(ENCODING));
        printBytes(encode);
    }

    @Test
    void base64BCDecode() throws UnsupportedEncodingException {
        byte[] decode = Base64.decode("Zm9v");// Zm9v
        printBytes(decode);
    }

    @Test
    void base64CCEncode() throws UnsupportedEncodingException {
        byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes(ENCODING));// Zm9v
        printBytes(bytes);
    }

    // CC特色
    @Test
    void base64CCEncodeSafe() throws UnsupportedEncodingException {
        byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes(), true);// Zm9v
        printBytes(bytes);
    }

    @Test
    void base64CCDecode() throws UnsupportedEncodingException {
        byte[] bytes = org.apache.commons.codec.binary.Base64.decodeBase64("Zm9v");
        printBytes(bytes);
    }

    private void printBytes(byte[] bytes) throws UnsupportedEncodingException {
        System.out.println(new String(bytes, ENCODING));
    }
}
