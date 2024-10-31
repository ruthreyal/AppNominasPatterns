<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Empleados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a {
            text-decoration: none;
            color: #007BFF;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Lista de Empleados</h1>
    <c:choose>
        <c:when test="${not empty lista}">
            <table>
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Sexo</th>
                    <th>Categoría</th>
                    <th>Años</th>
                    <th>Acciones</th>
                </tr>
                <c:forEach var="empleado" items="${lista}">
                    <tr>
                        <td><c:out value="${empleado.dni}" /></td>
                        <td><c:out value="${empleado.nombre}" /></td>
                        <td><c:out value="${empleado.sexo}" /></td>
                        <td><c:out value="${empleado.categoria}" /></td>
                        <td><c:out value="${empleado.anyos}" /></td>
                        <td><a href="empleado?opcion=editar&dni=${empleado.dni}">Editar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>${mensaje}</p> <!-- Mostrar el mensaje de error si no hay empleados -->
        </c:otherwise>
    </c:choose>

    <a href="index.jsp">Volver al menú</a>
</body>
</html>
                                                      

