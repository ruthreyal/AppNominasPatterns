package com.aprendec.factory;

import com.aprendec.model.Empleado;
import com.aprendec.model.Persona;
import com.aprendec.exceptions.DatosNoCorrectosException;

public class PersonaFactory {

    // Método para crear una instancia de Persona con nombre y sexo
    public static Persona createPersona(String nombre, char sexo) {
        return new Persona(nombre, sexo);
    }

    // Método para crear una instancia de Persona con nombre, dni y sexo
    public static Persona createPersona(String nombre, String dni, char sexo) {
        return new Persona(nombre, dni, sexo);
    }

    // Método para crear una instancia de Empleado con nombre, dni, sexo, categoría y años
    public static Empleado createEmpleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
        return new Empleado(nombre, dni, sexo, categoria, anyos);
    }

    // Método para crear una instancia de Empleado con nombre, dni y sexo, categoría por defecto
    public static Empleado createEmpleado(String nombre, String dni, char sexo) throws DatosNoCorrectosException {
        return new Empleado(nombre, dni, sexo);
    }

    // Método para crear una instancia de Empleado con nombre y sexo, con valores predeterminados
    public static Empleado createEmpleado(String nombre, char sexo) {
        return new Empleado(nombre, sexo);
    }
}

