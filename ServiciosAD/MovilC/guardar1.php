<?php
    /**
     * Permisos que para la comunicacion con un servidor real
     */
    header('Access-Controll-Allow-Origin:* ');
    header('Access-Controll-Allow-Headers: Origin, x-Requested-with, Content-Type, Authorization');
    header('Content-Type: application/json');
    header('Access-Control-Allow-Methods: POST, GET, OPTIONS, REQUEST');

    include "conexion.php";

    $cedula = $_REQUEST["cli_cedula"];
    $nombre = $_REQUEST["cli_nombre"];
    $apellido = $_REQUEST["cli_apellido"];
    $telefono = $_REQUEST["cli_telefono"];

    $sqlInsert = "INSERT INTO clientes (cli_cedula, cli_nombre, cli_apellido, cli_telefono)
                    VALUES ('$cedula', '$nombre', '$apellido', '$telefono')";

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