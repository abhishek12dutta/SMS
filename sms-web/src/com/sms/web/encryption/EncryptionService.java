package com.sms.web.encryption;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.sms.web.exception.SMSWebException;

public class EncryptionService {
	//static Log log = LogFactory.getLog(EncryptionService.class);

	/*private static byte[] key = { 0x74, 0x68, 0x45, 0x73, 0x49, 0x72, 0x42,
			0x53, 0x65, 0x61, 0x78, 0x65, 0x6a, 0x4b, 0x63, 0x65 };// "thisIsASecretKey";
*/	
	private static byte[] key = "thEsIrBSeaxejKce".getBytes(Charset.forName("UTF-8"));
	

	public static String encrypt(String strToEncrypt) throws SMSWebException {
		String encryptedString = null;
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			encryptedString = Base64.encodeBase64String(cipher
					.doFinal(strToEncrypt.getBytes()));

		} catch (Exception e) {
			throw new SMSWebException("Error while encrypting secure data");
		}
		return encryptedString;

	}

}