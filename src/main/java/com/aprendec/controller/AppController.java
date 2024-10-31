package com.aprendec.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/appcontroller")
public class AppController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        
        switch (opcion) {
            case "listar":
                // Redirige al EmpleadoServlet
                request.getRequestDispatcher("/empleado?opcion=listar").forward(request, response);
                break;
            case "buscarSueldo":
                request.getRequestDispatcher("/empleado?opcion=buscarSueldo").forward(request, response);
                break;
            case "editar":
                String dni = request.getParameter("dni");
                request.getRequestDispatcher("/empleado?opcion=editar&dni=" + dni).forward(request, response);
                break;
            case "filtrar":
                request.getRequestDispatcher("/empleado?opcion=filtrar").forward(request, response);
                break;
            default:
                // Manejo de opciones no reconocidas
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        
        switch (opcion) {
            case "buscar":
                request.getRequestDispatcher("/empleado?opcion=buscar").forward(request, response);
                break;
            case "actualizar":
                request.getRequestDispatcher("/empleado?opcion=actualizar").forward(request, response);
                break;
            case "buscarEmpleado":
                request.getRequestDispatcher("/empleado?opcion=buscarEmpleado").forward(request, response);
                break;
            default:
                // Manejo de opciones no reconocidas
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }
}

