<?php
//en modo servidor hay que dar permisos// sin los permisos solo modo local
header('Access-Control-Allow-Origen:*'); //de forma local el servicio
header('Access-Control-Allow-Headers:Origen,X-Request-with, Content-Type, Accept, Authorization'); //autorizacion de json
header('Content-Type: application/json'); //todo bajo json (OPCIONAL)
header('Access-Control-Allow-Method:POST,GET OPTIONS'); //tipo de encabezado en el sql json

include 'conexion.php';

$calle1 = $_POST['calle1'];

$sqlDelete = "DELETE FROM lugar WHERE calle1='$calle1'";

if ($conn->query($sqlDelete) === true) {
    echo json_encode("OK");
} else {
    echo json_encode("Error");
}

$mysqli->close();