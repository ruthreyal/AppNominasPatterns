package com.aprendec.model;

public class Nomina {
    
    private static final int SUELDO_BASE[] = {
        50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000
    };
    
    public double sueldo(Empleado emp) {
        int categoriaSueldo = emp.getCategoria();
        
        // Asegúrate de que la categoría está dentro de los límites
        if (categoriaSueldo < 1 || categoriaSueldo > SUELDO_BASE.length) {
            throw new IllegalArgumentException("Categoría de sueldo no válida: " + categoriaSueldo);
        }
        
        return SUELDO_BASE[categoriaSueldo - 1] + 5000 * emp.getAnyos();
    }
}
