package com.lastminute.javatest.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Utils {
	
	/*
	 * Rounds up to the nearest 0.05
	 */
	public static float roundUpNearest005(float n) {
		BigDecimal d = new BigDecimal(n);
		BigDecimal scale = new BigDecimal("0.05"); // the rounding policy
		BigDecimal y = d.divide(scale);
		BigDecimal q = y.setScale(0, BigDecimal.ROUND_UP); // round up
		BigDecimal z = q.multiply(scale);
		return z.floatValue();
	}
	
	/*
	 * Prints the input string if clause
	 */
	public static String getStringIf(String s, boolean clause) {
		if (clause)
			return s;
		else
			return "";
	}
	
	/*
	 * Formats decimal numbers like #.##
	 */
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
