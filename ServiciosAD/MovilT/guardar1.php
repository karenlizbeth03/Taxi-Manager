<?php
    /**
     * Permisos que para la comunicacion con un servidor real
     */
    header('Access-Controll-Allow-Origin:* ');
    header('Access-Controll-Allow-Headers: Origin, x-Requested-with, Content-Type, Authorization');
    header('Content-Type: application/json');
    header('Access-Control-Allow-Methods: POST, GET, OPTIONS, REQUEST');

    include "conexion.php";

    $coop = $_REQUEST["tax_cooperativa"];
    $nombre = $_REQUEST["tax_nombre"];
    $apellido = $_REQUEST["tax_apellido"];
    $estado = $_REQUEST["tax_estado"];
   

    $sqlInsert = "INSERT INTO taxi(tax_cooperativa, tax_nombre, tax_apellido, tax_estado, cli_cedula)
                    VALUES ('$coop', '$nombre', '$apellido', '$estado', '$cliente')";

    try {
        if ($mysqli->query($sqlInsert) === TRUE) {
            # echo json_encode("¡Insersión Exitosa!");
            echo json_encode(array("ok" => true));
        } else {
            # echo json_encode("ERROR: ".mysqli_connect_error());
            echo json_encode(array("ok" => false, 'errorMsg' => $sqlInsert.$mysqli -> error));
        }    

    } catch (\Throwable $th) {
        echo json_encode(array("ok" => false, 'errorMsg' => $th));
    }
    
    $mysqli->close();
?>