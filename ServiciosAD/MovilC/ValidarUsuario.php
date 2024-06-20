<?php
$conexion = mysqli_connect("localhost","root","","appdis");
if (!$conexion){
    echo"error en conexion";
}

$cedula=$_POST['cli_cedula'];
$telefono=$_POST['cli_telefono'];
//$cedula="1801";
//$telefono="123";
$query = "SELECT * FROM clientes WHERE cli_cedula='$cedula' AND cli_telefono='$telefono'";
$resultado=mysqli_query($conexion,$query);
if($resultado->num_rows>0){
    echo "Ingreso Correctamente";
}else{
    echo "no puede ingresar";
}


/*
header('Access-Control-Allow-Origen:*');
header('Access-Control-Allow-Header:Origen,X-Request-with-Content-Type,Accept,Authorization');
header('Content-Type: application/json');
header('Access-Control-Allow-Method: POST,GET OPTIONS');
include 'conexion.php';
$cedula=$_POST['cli_cedula'];
$telefono=$_POST['cli_telefono'];
//$cedula="1801";
//$telefono="123";

$sentencia=$conexion->prepare("SELECT * FROM clientes WHERE cli_cedula=? AND cli_telefono=?");
$sentencia->bind_param('ss',$cedula,$telefono);
$sentencia->execute();

$resultado = $sentencia->get_result();
if ($fila = $resultado->fetch_assoc()) {
         echo json_encode($fila,JSON_UNESCAPED_UNICODE);     
}
$sentencia->close();
$conexion->close();*/
?>
