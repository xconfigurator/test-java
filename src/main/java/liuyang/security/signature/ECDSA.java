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
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

public class ECDSA {

	private static final String ALGORITHM = "EC";
	private static final String ALGORITHM_SIGNATURE = "SHA1withECDSA";
	private static String SRC = "liuyang";

	public static void main(String[] args)
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		implJDK();
	}

	public static void implJDK()
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		// 1. 初始化密钥
		KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
		generator.initialize(256);
		KeyPair pair = generator.genKeyPair();
		ECPublicKey ecPublicKey = (ECPublicKey) pair.getPublic();
		ECPrivateKey ecPrivateKey = (ECPrivateKey) pair.getPrivate();

		// 2. 执行签名
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance(ALGORITHM_SIGNATURE);
		signature.initSign(privateKey);
		signature.update(SRC.getBytes());
		byte[] result = signature.sign();
		System.out.println("JDK ECDSA Sign : " + Hex.encodeHexString(result));

		// 3. 验证签名
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance(ALGORITHM);
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance(ALGORITHM_SIGNATURE);
		signature.initVerify(publicKey);
		signature.update(SRC.getBytes());
		boolean bool = signature.verify(result);
		System.out.println("JDK ECDSA Verify : " + bool);
	}

	public static void implBC() {

	}

}
