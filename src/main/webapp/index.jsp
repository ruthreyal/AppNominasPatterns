<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Menú de Opciones</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }
        body > h1 { color: #333; tex-align: center; padding-botton: 30px;}
        table { width: 50%; margin: 20px auto; border-collapse: collapse; }
        td { padding: 10px; text-align: center; background-color: #fff; border: 1px solid #ccc; }
        a { text-decoration: none; color: #007BFF; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <h1>Menu de Opciones</h1>
    <table>
        <tr>
            <td><a href="appcontroller?opcion=listar">Mostrar Empleados</a></td>
        </tr>
        <tr>
            <td><a href="appcontroller?opcion=buscarSueldo">Buscar Sueldo</a></td>
        </tr>
        <tr>
            <td><a href="appcontroller?opcion=filtrar">Buscar Empleado</a></td> 
        </tr>
    </table>
</body>
</html>
