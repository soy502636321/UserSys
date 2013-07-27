package soy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 主要用来实现系统用户的密码加密的功能
 * 
 * @author 
 * 
 */
public class PasswordControl {
	/* 用来加密的种子 */
	private static String passwordSeed = "hqmis";

	/**
	 * 用MD5算法将password进行加密，然后返回加密之后的新密码.
	 * 
	 * @param password
	 * @return
	 */
	public static String EncryptePassword(String password) {
		// System.out.println(password + "-----" + password.length());
		String passwordMD5 = MD5Crypt.crypt(password, passwordSeed);
		// System.out.println(passwordMD5 + "-----" + passwordMD5.length());
		return passwordMD5;
	}
	
	/**
	 * 得到随机密码。
	 * @return
	 */
	public static String getNewPassword(){
		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyz");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < 8; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	public static void main(String args[]) {
//		List testList = new ArrayList();
//		testList.add("superPassword");
//		testList.add("123");
//		testList.add("44444");
//		testList.add("7777777777777777");
//
//		for (Object obj : testList) {
//			System.out.println(PasswordControl.EncryptePassword((String) obj));
//		}

		System.out.println(getNewPassword());
		System.out.println(EncryptePassword("123"));
	}
}
