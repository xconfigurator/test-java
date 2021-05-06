package liuyang.tools.security.rsa.encode;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA 私钥加密公钥解密的演示
 * 说明：对比可知Druid数据源产品对密码的加密。可以回答为什么只需要配置公钥这个问题。
 * @author liuyang
 * @since 2021/5/6
 *
 * 参考：https://www.imooc.com/video/6280
 */
public class RSA {

    private static final String ALGORITHM = "RSA";
    // private static final String ALGORITHM_SIGNATURE = "MD5withRSA";
    private static String SRC = "liuyang"; // 待加密字符串

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        implJDK();
    }

    // 演示私钥加密 公钥解密的过程
    public static void implJDK() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // 1. 初始化密钥
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
        generator.initialize(512);// 必须是64的整数倍
        KeyPair pair = generator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) pair.getPublic();// 公钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) pair.getPrivate();// 私钥
        System.out.println("Public Key:" + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
        System.out.println("Private Key:" + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));

        // 2. 私钥加密
        // 输入1：rsaPrivateKey
        // 输入2：SRC
        // 输出 ：SRC被私钥加密后的值
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(SRC.getBytes());
        System.out.println("SRC密文: " + Base64.encodeBase64String(result));

        // 3. 公钥解密
        // 输入1：rsaPublicKey
        // 输入2：SRC被私钥加密后的值
        // 输出： SRC明文
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        result = cipher.doFinal(result);
        System.out.println("SRC明文：" + new String(result));
    }

    // TODO 公钥加密 私钥解密 视频的12:40开始介绍
}
