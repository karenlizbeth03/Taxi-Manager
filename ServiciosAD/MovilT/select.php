<?php
include "conexion.php";
$sqlselect='SELECT  * FROM lugar';
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
    $result="No hay lugares";
}
echo json_encode($result);

?>