package edu.ude.bedelia.servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.logica.vo.VOInscripcion;

public class EscolaridadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// obtengo los datos del Request
		String ci = req.getParameter("cedula");
		RequestDispatcher rd = null;
		String ipservidor = (String) getServletContext().getInitParameter("ipservidor");
		String puerto = (String) getServletContext().getInitParameter("puerto");
		String objeto = (String) getServletContext().getInitParameter("objeto");
		String url = UrlBuilder.buildUrl(ipservidor, puerto, objeto);
		try {
			if (ci != null) {
				IFachada fachada = (IFachada) Naming.lookup(url);
				ArrayList<VOInscripcion> escolaridad = fachada.listarEscolaridad(ci, false);
				req.setAttribute("escolaridad", escolaridad);
				req.setAttribute("cedula", ci);
			}	

			rd = req.getRequestDispatcher("escolaridad.jsp");
		} catch (AlumnosException e) {
			req.setAttribute("error", e.getMessage());		
			rd = req.getRequestDispatcher("escolaridad.jsp");
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
			rd = req.getRequestDispatcher("error.jsp");
		}
		
		rd.forward(req, resp);
	}
}
