package edu.ude.bedelia.servlets;

public final class UrlBuilder {
	public final static String TEM_URL = "//%s:%s/%s";

	public static String buildUrl(final String ip, final String port, final String mothod) {
		return String.format(TEM_URL, ip, port, mothod);
	}
}
