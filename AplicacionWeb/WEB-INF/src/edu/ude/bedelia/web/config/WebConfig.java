package edu.ude.bedelia.web.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebConfig {

	private final static String TEM_URL = "//%s:%s/%s";

	private String ip = Constantes.Configuraciones.IP_POR_DEFECTO;
	private String puerto = Constantes.Configuraciones.IP_POR_DEFECTO;
	private String objeto;

	public WebConfig(String ip, String puerto, String objeto) {
		super();
		this.ip = ip;
		this.puerto = puerto;
		this.objeto = objeto;
	}

	public String getIp() {
		return ip;
	}

	public String getPuerto() {
		return puerto;
	}

	public String getObjeto() {
		return objeto;
	}

	public String getUrl() {
		return String.format(TEM_URL, ip, puerto, objeto);
	}

}
