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

		try {
			IFachada fachada = (IFachada) Naming.lookup("//192.168.0.100:1024/bedelias");
			ArrayList<VOEgresado> egresados = fachada.listarEgresados(false);
			req.setAttribute("egresados", egresados);
			System.out.println("-------------------------->"+egresados);	
			rd = req.getRequestDispatcher("egresados.jsp");
		} catch (Exception e) {
			rd = req.getRequestDispatcher("Error.jsp");
		}
		
		rd.forward(req, resp);
	}
}
