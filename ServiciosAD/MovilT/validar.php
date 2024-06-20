<?php
$conexion = mysqli_connect("localhost","root","","appdis");
if (!$conexion){
    echo"error en conexion";
}

$coop=$_POST['tax_cooperativa'];
$nombre=$_POST['tax_nombre'];
//$coop="1801";
//$nombre="123";
$query = "SELECT * FROM taxi WHERE tax_cooperativa='$coop' AND tax_nombre='$nombre'";
$resultado=mysqli_query($conexion,$query);
if($resultado->num_rows>0){
    echo "Ingreso Correctamente";
}else{
    echo "no puede ingresar";
}