<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Editar Empleado</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }
        h1 { color: #333; }
        form { margin: 20px auto; width: 300px; }
        label, input { display: block; margin: 10px 0; }
        input[type="submit"] { background-color: #007BFF; color: white; border: none; padding: 10px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <h1>Editar Empleado</h1>
    <form action="appcontroller" method="post">
        <input type="hidden" name="opcion" value="actualizar">
        <input type="hidden" name="dni" value="${empleado.dni}">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${empleado.nombre}">
        <label for="sexo">Sexo:</label>
        <input type="text" id="sexo" name="sexo" value="${empleado.sexo}">
        <label for="categoria">Categoría:</label>
        <input type="number" id="categoria" name="categoria" value="${empleado.categoria}">
        <label for="anyos">Años:</label>
        <input type="number" id="anyos" name="anyos" value="${empleado.anyos}">
        <input type="submit" value="Actualizar">
    </form>
</body>
</html>



