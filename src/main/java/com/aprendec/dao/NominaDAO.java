package com.aprendec.dao;

import com.aprendec.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NominaDAO {

    // Método para obtener el sueldo por DNI
    public Double obtenerSueldoPorDni(String dni) {
        Double salario = null;
        String sql = "SELECT sueldo_final FROM nominas WHERE dni = ?";
        
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, dni);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                salario = rs.getDouble("sueldo_final");
            }
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salario;
    }


  
}

