package edu.ude.bedelia.web.servlets;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.logica.vo.VOEgresado;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.web.config.Constantes;
import edu.ude.bedelia.web.config.WebConfig;
import valueObjects.DataMensaje;
import valueObjects.DataPersona;

public class EgresadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFachada fachada = null;;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			final WebConfig configuracion = new WebConfig(getServletContext().getInitParameter(Constantes.Configuraciones.CLAVE_IP), 
					getServletContext().getInitParameter(Constantes.Configuraciones.CLAVE_PUERTO), 
					getServletContext().getInitParameter(Constantes.Configuraciones.CLAVE_OBJETO));
			fachada  = Sistema.getInstancia(configuracion).getFachadaInstance();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher rd;
		try {
			List <VOEgresado>  resultado = fachada.listarEgresados(false);
			req.setAttribute("data_list", resultado);
			rd = req.getRequestDispatcher("Listado.jsp");
		} catch (RemoteException e) {
			req.setAttribute("msg_error", e.getMessage());
			rd = req.getRequestDispatcher("Error.jsp");
		}
		rd.forward(req, resp);
	}
}
