<?php
include "conexion.php";
$sqlselect='SELECT  * FROM taxi';
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
    $result="No hay taxis";
}
echo json_encode($result);
?>
