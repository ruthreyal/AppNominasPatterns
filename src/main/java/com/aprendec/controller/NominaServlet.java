package com.aprendec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aprendec.dao.NominaDAO;

@WebServlet("/nomina")
public class NominaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NominaDAO nominaDAO;

    public void init() throws ServletException {
        nominaDAO = new NominaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        if ("buscarSueldo".equals(opcion)) {
            String dni = request.getParameter("dni");
            Double sueldo = nominaDAO.obtenerSueldoPorDni(dni);
            request.setAttribute("sueldo", sueldo);
            request.getRequestDispatcher("views/buscarSueldo.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
    if ("buscar".equals(opcion)) {
        String dni = request.getParameter("dni");
        Double salario = nominaDAO.obtenerSueldoPorDni(dni);
		if (salario == null) {
		    request.setAttribute("mensaje", "No se encontró un sueldo o empleado con el DNI ingresado.");
		} else {
		    request.setAttribute("salario", salario);
		    request.setAttribute("dni", dni);
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/resultadoSueldo.jsp");
		requestDispatcher.forward(request, response);
    }
    }
}


