<?php
//en modo servidor hay que dar permisos// sin los permisos solo modo local
header('Access-Control-Allow-Origen:*'); //de forma local el servicio
header('Access-Control-Allow-Headers:Origen,X-Request-with, Content-Type, Accept, Authorization'); //autorizacion de json
header('Content-Type: application/json'); //todo bajo json (OPCIONAL)
header('Access-Control-Allow-Method:POST,GET OPTIONS'); //tipo de encabezado en el sql json

include 'conexion.php';

$coop = $_POST['tax_cooperativa'];

$sqlDelete = "DELETE FROM taxi WHERE tax_cooperativa='$coop'";

if ($conn->query($sqlDelete) === true) {
    echo json_encode("OK");
} else {
    echo json_encode("Error");
}

$mysqli->close();