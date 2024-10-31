<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú de Opciones</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        .container {
            text-align: center;
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }
        td {
            padding: 15px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
        }
        a {
            color: #007BFF;
            font-weight: bold;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Menú de Opciones</h1>
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
    </div>
</body>
</html>

