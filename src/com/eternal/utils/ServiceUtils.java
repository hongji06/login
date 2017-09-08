package com.eternal.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class ServiceUtils {

	public static String md5(String message) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] digest = md.digest(message.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();		
			return encoder.encode(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
