package liuyang.security.signature;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * RSA 私钥加密公钥解密的演示（签名）
 *
 * 私钥加密公钥解密
 * 目的：保证身份不可伪造
 * 解释：只有持有私钥的人才能发出消息。
 */
public class RSA {
	
	private static final String ALGORITHM = "RSA";
	private static final String ALGORITHM_SIGNATURE = "MD5withRSA";
	private static String SRC = "liuyang";

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, InvalidKeySpecException {
		implJDK();
	}

	public static void implJDK() throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException {
		// 发送方 ///////////////////////////////////////////////////////
		// 1. 初始化密钥
		KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
		generator.initialize(512);// 必须是64的整数倍
		KeyPair pair = generator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey) pair.getPublic();// 公钥 (注：验签时公钥的分发问题通过引入根证书来解决。实际并不是“分发”的，而是将有资质的CA的公钥固化在OS中。)
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) pair.getPrivate();// 私钥
		System.out.println("Public Key:" + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
		System.out.println("Private Key:" + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
		
		// 2. 执行签名
		// 输入：rsaPrivateKey， SRC(待签名内容)
		// 输出：result（签名）
		// 约定：与接收方使用相同的ALGORITHM_SIGNATURE
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance(ALGORITHM_SIGNATURE);
		signature.initSign(privateKey);// 私钥签名
		signature.update(SRC.getBytes());
		byte[] result = signature.sign();// 需要发送给接收方
		System.out.println("JDK RSA Sign: " + Hex.encodeHexString(result));
		
		// 接收方 ///////////////////////////////////////////////////////
		// 3. 验证签名
		// 输入：rsaPublicKey， SRC（签名内容） 
		// 输出：是否验证通过
		// 约定：与接收方使用相同的ALGORITHM_SIGNATURE 
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance(ALGORITHM);
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance(ALGORITHM_SIGNATURE);
		signature.initVerify(publicKey);// 公钥验证
		signature.update(SRC.getBytes());
		boolean bool = signature.verify(result);
		System.out.println("JDK RSA Verify: " + bool);
	}
	
	public static void implBC() {
		
	}
}
