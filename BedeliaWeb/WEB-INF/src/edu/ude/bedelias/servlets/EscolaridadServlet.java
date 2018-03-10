package edu.ude.bedelias.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EscolaridadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// obtengo los datos del Request
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("Error.jsp");
		rd.forward(req, resp);

	}
}
