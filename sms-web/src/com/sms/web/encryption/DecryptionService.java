package com.sms.web.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.sms.web.exception.SMSWebException;

public class DecryptionService {
	//static Log log = LogFactory.getLog(DecryptionService.class);

	private static byte[] key = { 0x74, 0x68, 0x45, 0x73, 0x49, 0x72, 0x42,
			0x53, 0x65, 0x61, 0x78, 0x65, 0x6a, 0x4b, 0x63, 0x65 };// "thisIsASecretKey";
	//private static byte[] key = "thEsIrBSeaxejKce".getBytes(Charset.forName("UTF-8"));

	public static String decrypt(String strToDecrypt) throws SMSWebException {
		String decryptedString = null;
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			decryptedString = new String(cipher.doFinal(Base64
					.decodeBase64(strToDecrypt)));

		} catch (Exception e) {
			throw new SMSWebException("Error while decrypt secure data");

		}
		return decryptedString;
	}
}
