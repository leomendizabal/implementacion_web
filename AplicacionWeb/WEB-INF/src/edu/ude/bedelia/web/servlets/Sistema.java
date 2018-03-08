package edu.ude.bedelia.web.servlets;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.web.config.WebConfig;

public class Sistema {

	private static Sistema instancia;
	private static IFachada fachadaInstance;

	protected Sistema(WebConfig config) throws MalformedURLException, RemoteException, NotBoundException {
		super();
		final String url = config.getUrl();
		System.out.println("URL ==> " + url);
		this.fachadaInstance = (IFachada) Naming.lookup(url);
	}

	public static Sistema getInstancia(WebConfig config) throws MalformedURLException, RemoteException, NotBoundException {
		if (instancia == null) {
			instancia = new Sistema(config);
		}

		return instancia;
	}

	public IFachada getFachadaInstance() {
		return fachadaInstance;
	}
}
