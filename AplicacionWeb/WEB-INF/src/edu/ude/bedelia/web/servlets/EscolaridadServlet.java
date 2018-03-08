package edu.ude.bedelia.web.servlets;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.logica.vo.VOInscripcion;
import edu.ude.bedelia.web.config.Constantes;
import edu.ude.bedelia.web.config.StringsUtil;
import edu.ude.bedelia.web.config.WebConfig;

public class EscolaridadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IFachada fachada = null;

	@Override
	public void init() throws ServletException {
		try {
			final WebConfig configuracion = new WebConfig(
					getServletContext().getInitParameter(Constantes.Configuraciones.CLAVE_IP),
					getServletContext().getInitParameter(Constantes.Configuraciones.CLAVE_PUERTO),
					getServletContext().getInitParameter(Constantes.Configuraciones.CLAVE_OBJETO));
			fachada = Sistema.getInstancia(configuracion).getFachadaInstance();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.init();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// obtengo los datos del Request
		RequestDispatcher rd;
		// TODO: Pasar a constantes
		final String cedula = req.getParameter(Constantes.RequestParam.PARAM_CI);
		if (StringsUtil.isEmpty(cedula)) {
			req.setAttribute("msg_error", "La cedula no puede ser vacia");
			rd = req.getRequestDispatcher("Error.jsp");
		} else {
			try {
				List<VOInscripcion> resultado = fachada.listarEscolaridad(cedula, false);
				req.setAttribute("data_list", resultado);
				rd = req.getRequestDispatcher("Listado.jsp");
			} catch (AlumnosException e) {
				req.setAttribute("msg_error", e.getMessage());
				rd = req.getRequestDispatcher("Error.jsp");
			}

		}
		rd.forward(req, resp);
	}
}
