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
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

public class DSA {

	private static final String ALGORITHM = "DSA";
	private static final String ALGORITHM_SIGNATURE = "SHA1withDSA";
	private static String SRC = "liuyang";
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, SignatureException {
		implJDK();
	}
	
	public static void implJDK() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		// 1. 初始化密钥
		KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
		generator.initialize(512);
		KeyPair pair = generator.generateKeyPair();
		DSAPublicKey dsaPublicKey = (DSAPublicKey) pair.getPublic();
		DSAPrivateKey dsaPrivateKey = (DSAPrivateKey) pair.getPrivate();
		
		// 2. 执行签名
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance(ALGORITHM_SIGNATURE);
		signature.initSign(privateKey);
		signature.update(SRC.getBytes());
		byte[] result = signature.sign();
		System.out.println("JDK DSA Sign : " + Hex.encodeHexString(result));
		
		// 3. 验证签名
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance(ALGORITHM);
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance(ALGORITHM_SIGNATURE);
		signature.initVerify(publicKey);
		signature.update(SRC.getBytes());
		boolean bool = signature.verify(result);
		System.out.println("JDK DSA Verify : " + bool);
	}

	public static void implBC() {
		
	}
}
