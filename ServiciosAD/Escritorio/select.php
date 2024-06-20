<?php
include "conexion.php";
$sqlselect='SELECT  * FROM clientes';
$respuesta=$conn->query($sqlselect);
$result=array();

if($respuesta->num_rows>0)
{
    while($filaestudiantes=$respuesta->fetch_assoc())
    {
        array_push($result,$filaestudiantes);

    }
}
else {
    $result="No hay clientes";
}
echo json_encode($result);

?>