<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Resultado de Sueldo</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }
        h1 { color: #333; }
        p { font-size: 18px; }
        a { color: #007BFF; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <h1>Resultado de Sueldo</h1>

    <c:choose>
        <c:when test="${not empty mensaje}">
            <p><strong>${mensaje}</strong></p>
        </c:when>
        <c:otherwise>
            <p>El salario del empleado con DNI <strong>${dni}</strong> es: <strong>${salario}</strong> euros</p>
        </c:otherwise>
    </c:choose>

    <a href="index.jsp">Volver al menú</a>
</body>
</html>



