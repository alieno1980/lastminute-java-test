package com.lastminute.javatest.common;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Utils {

	public static float round005(float n) {
		return Math.round(n * 20f) / 20f;
	}
	
	public static String getStringIf(String s, boolean clause) {
		if (clause)
			return s;
		else
			return "";
	}
	
	public static String getFormattedDecimal(String pattern, float n) {
		String formattedDecimalString = new DecimalFormat(pattern).format(n);
		if (formattedDecimalString.indexOf(",") < 0)
			return formattedDecimalString + ",00";
		
		StringTokenizer tokenizer = new StringTokenizer(formattedDecimalString, ",");
		tokenizer.nextToken();
		if (tokenizer.nextToken().length() == 1)
			return formattedDecimalString + "0";
		else
			return formattedDecimalString;
	}
	
}
