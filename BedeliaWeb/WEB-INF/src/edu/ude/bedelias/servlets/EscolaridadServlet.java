package edu.ude.bedelias.servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
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
		
		/*if(ci != null) {
			try {
				IFachada fachada = (IFachada) Naming.lookup("192.168.0.102:1024");
				ArrayList<VOInscripcion> escolaridad = fachada.listarEscolaridad(ci, false);
				req.setAttribute("escolaridad", escolaridad);
				rd = req.getRequestDispatcher("escolaridad.jsp");
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AlumnosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}*/
		try {
			IFachada fachada = (IFachada) Naming.lookup("//192.168.0.104:1024/bedelias");
			ArrayList<VOInscripcion> escolaridad = fachada.listarEscolaridad("2222222", false);
			req.setAttribute("escolaridad", escolaridad);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rd = req.getRequestDispatcher("escolaridad.jsp");
		rd.forward(req, resp);
	}
}
