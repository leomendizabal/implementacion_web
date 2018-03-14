package edu.ude.bedelia.servlets;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ude.bedelia.logica.fachada.IFachada;
import edu.ude.bedelia.logica.vo.VOEgresado;

public class EgresadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;		
		String ci = req.getParameter("cedula");
		String ipservidor = (String) getServletContext().getInitParameter("ipservidor");
		String puerto = (String) getServletContext().getInitParameter("puerto");
		String objeto = (String) getServletContext().getInitParameter("objeto");
		String url = "//" + ipservidor + ":" + puerto + "/" + objeto;
		
		try {
			IFachada fachada = (IFachada) Naming.lookup(url);
			ArrayList<VOEgresado> egresados = fachada.listarEgresados(false);
			req.setAttribute("egresados", egresados);
			System.out.println("-------------------------->"+egresados);	
			rd = req.getRequestDispatcher("egresados.jsp");
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
			rd = req.getRequestDispatcher("error.jsp");
		}
		
		rd.forward(req, resp);
	}
}
