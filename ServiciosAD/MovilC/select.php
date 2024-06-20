<?php

// todo lo que venga se recibe en formato json
header('Access-Control-Allow-Origen:*');

//autorizacion de manipulacion de json
header('Access-Control-Allow-Header:Origen,X-Request-with-Content-Type,Accept,Authorization');

//lo que se va ha manejar lo hace bajo json
header('Content-Type: application/json');

// Que tipo de sentencia sql se va hacer a traves del json.
header('Access-Control-Allow-Method: POST,GET OPTIONS');

include "conexion.php";

$cedula = $_POST['cli_cedula'];

$sqlselect = "SELECT * FROM lugar WHERE cli_cedula LIKE '%$cedula%'";
$respuesta = $mysqli->query($sqlselect);

$result = array();

if ($respuesta->num_rows > 0) {
    while ($fila = $respuesta->fetch_assoc()) {
        array_push($result, $fila);
    }
} else {
    $result = "No hay solicitudes";
}

echo json_encode($result);

?>