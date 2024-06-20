<?php
    //en modo servidor hay que dar permisos// sin los permisos solo modo local
    header('Access-Control-Allow-Origen:*');//de forma local el servicio
    header('Access-Control-Allow-Headers:Origen,X-Request-with, Content-Type, Accept, Authorization');//autorizacion de json
    header('Content-Type: application/json');//todo bajo json (OPCIONAL)
    header('Access-Control-Allow-Method:POST,GET OPTIONS');//tipo de encabezado en el sql json


    
    include 'conexion.php';
    $coop=$_POST['tax_cooperativa'];
    
    $estado=$_POST['tax_estado'];
    $cliente=$_POST['cli_cedula'];
    $sqlUpdate = "UPDATE taxi SET  tax_estado='$estado', cli_cedula='$cliente' WHERE tax_cooperativa='$coop'";

    if($conn->query($sqlUpdate)==true){
        echo json_encode("OK");
    }else{
        echo json_encode("error");
    }

    $mysqli->close();
?>