package com.aprendec.controller;

import com.aprendec.dao.EmpleadoDAO;
import com.aprendec.exceptions.DatosNoCorrectosException;
import com.aprendec.factory.PersonaFactory;
import com.aprendec.model.Empleado;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/empleado")
public class EmpleadoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpleadoDAO empleadoDAO;

    @Override
    public void init() throws ServletException {
        empleadoDAO = new EmpleadoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if ("listar".equals(opcion)) {
            List<Empleado> listaEmpleados = empleadoDAO.obtenerEmpleados();
            request.setAttribute("lista", listaEmpleados);
            request.getRequestDispatcher("views/listar.jsp").forward(request, response);
        } else if ("editar".equals(opcion)) {
            String dni = request.getParameter("dni");
            Empleado empleado;
            try {
                empleado = empleadoDAO.obtenerEmpleadoPorDni(dni);
                request.setAttribute("empleado", empleado);
                request.getRequestDispatcher("views/editarEmpleado.jsp").forward(request, response);
            } catch (DatosNoCorrectosException e) {
                e.printStackTrace();
            }
        } else if ("filtrar".equals(opcion)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpleado.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if ("actualizar".equals(opcion)) {
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            char sexo = request.getParameter("sexo").charAt(0);
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            int anyos = Integer.parseInt(request.getParameter("anyos"));

            Empleado empleado;
			try {
				empleado = PersonaFactory.createEmpleado(nombre, dni, sexo, categoria, anyos);
				empleadoDAO.actualizarEmpleado(empleado);
				response.sendRedirect("appcontroller?action=empleado&opcion=listar"); // Redirige al AppController
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        } else if ("buscarEmpleado".equals(opcion)) {
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
            String categoriaStr = request.getParameter("categoria");
            String anyosStr = request.getParameter("anyos");

            Integer categoria = (categoriaStr != null && !categoriaStr.isEmpty()) ? Integer.parseInt(categoriaStr) : null;
            Integer anyos = (anyosStr != null && !anyosStr.isEmpty()) ? Integer.parseInt(anyosStr) : null;

            try {
                List<Empleado> empleados = empleadoDAO.buscarEmpleados(dni, nombre, sexo, categoria, anyos);
                request.setAttribute("lista", empleados);
                
              
                if (empleados.isEmpty()) {
                    request.setAttribute("mensaje", "No se encontraron empleados con los criterios de búsqueda.");
                }
                
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DatosNoCorrectosException e) {
                e.printStackTrace();
            }
        }



    }
    
}
