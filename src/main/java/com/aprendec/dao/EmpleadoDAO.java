package com.aprendec.dao;

import com.aprendec.conexion.Conexion;
import com.aprendec.exceptions.DatosNoCorrectosException;
import com.aprendec.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    // Método para obtener todos los empleados
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conexion.getConnection();
            String sql = "SELECT dni, nombre, sexo, categoria, anyos FROM empleados"; // Ajusta la consulta según tu tabla
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                try {
                    Empleado empleado = new Empleado(
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("sexo").charAt(0),
                        rs.getInt("categoria"),
                        rs.getInt("anyos")
                    );
                    empleados.add(empleado);
                    
                    
                } catch (DatosNoCorrectosException e) {
                    e.printStackTrace(); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                Conexion.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return empleados;

       
    }

   

    // Método para obtener un empleado por DNI
    public Empleado obtenerEmpleadoPorDni(String dni) throws DatosNoCorrectosException {
        Empleado empleado = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = Conexion.getConnection();
            String sql = "SELECT dni, nombre, sexo, categoria, anyos FROM empleados WHERE dni = ?"; // Consulta para buscar por DNI
            ps = connection.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado(
                    rs.getString("nombre"),
                    rs.getString("dni"),
                    rs.getString("sexo").charAt(0),
                    rs.getInt("categoria"),
                    rs.getInt("anyos")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
           
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                Conexion.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return empleado;
    }
    
    private Connection obtenerConexion() throws SQLException{
    	return Conexion.getConnection();
    }
    
   
    public void actualizarEmpleado(Empleado empleado) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = Conexion.getConnection();
            String sql = "UPDATE empleados SET nombre=?, sexo=?, categoria=?, anyos=? WHERE dni=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, String.valueOf(empleado.getSexo()));
            ps.setInt(3, empleado.getCategoria());
            ps.setInt(4, empleado.getAnyos());
            ps.setString(5, empleado.getDni());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                Conexion.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Empleado> buscarEmpleados(String dni, String nombre, String sexo, Integer categoria, Integer anyos) throws SQLException, DatosNoCorrectosException {
        List<Empleado> empleados = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT dni, nombre, sexo, categoria, anyos FROM empleados WHERE 1=1");

        if (dni != null && !dni.isEmpty()) {
            sql.append(" AND dni = ?");
        }
        if (nombre != null && !nombre.isEmpty()) {
            sql.append(" AND nombre LIKE ?");
        }
        if (sexo != null && !sexo.isEmpty()) {
            sql.append(" AND sexo = ?");
        }
        if (categoria != null) {
            sql.append(" AND categoria = ?");
        }
        if (anyos != null) {
            sql.append(" AND anyos = ?");
        }

        try (Connection connection = Conexion.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql.toString())) {

            int paramIndex = 1;

            if (dni != null && !dni.isEmpty()) {
                ps.setString(paramIndex++, dni);
            }
            if (nombre != null && !nombre.isEmpty()) {
                ps.setString(paramIndex++, "%" + nombre + "%");
            }
            if (sexo != null && !sexo.isEmpty()) {
                ps.setString(paramIndex++, sexo);
            }
            if (categoria != null) {
                ps.setInt(paramIndex++, categoria);
            }
            if (anyos != null) {
                ps.setInt(paramIndex++, anyos);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Empleado empleado = new Empleado(
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("sexo").charAt(0),
                        rs.getInt("categoria"),
                        rs.getInt("anyos")
                    );
                    empleados.add(empleado);
                }
            }
        }

        return empleados;
    }



}

