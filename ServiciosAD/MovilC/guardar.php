<?php
    /**
     * Permisos que para la comunicacion con un servidor real
     */
    header('Access-Controll-Allow-Origin:* ');
    header('Access-Controll-Allow-Headers: Origin, x-Requested-with, Content-Type, Authorization');
    header('Content-Type: application/json');
    header('Access-Control-Allow-Methods: POST, GET, OPTIONS, REQUEST');

    include "conexion.php";

    $calle1 = $_REQUEST["calle1"];
    $calle2 = $_REQUEST["calle2"];
    $referencia = $_REQUEST["referencia"];
    $barrrio = $_REQUEST["barrio"];
    $info = $_REQUEST["info"];
    $cliente = $_REQUEST["cli_cedula"];

    $sqlInsert = "INSERT INTO lugar(calle1, calle2, referencia, barrio,info,cli_cedula)
                    VALUES ('$calle1', '$calle2', '$referencia', '$barrrio', '$info','$cliente')";

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