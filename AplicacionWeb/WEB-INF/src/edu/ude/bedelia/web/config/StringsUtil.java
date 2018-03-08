package edu.ude.bedelia.web.config;

public final class StringsUtil {

	public static boolean isEmpty(final String str) {
		return (str == null) ? false : str.trim().isEmpty();
	}
}
