package com.huishu.commom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilHelper {

	/**
	 * 校验密码
	 */
	public static boolean checkPassword(String password) {
		String pattern = "^[a-zA-Z]\\w{5,17}$";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(password);
		return m.matches();
	}
}
