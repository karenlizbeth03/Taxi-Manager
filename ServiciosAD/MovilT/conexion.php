<?php
$servername="localhost";
$username="root";
$password="";
$database="appdis";
$conn=mysqli_connect($servername,$username,$password,$database);
$mysqli=new mysqli($servername,$username,$password,$database);

if(!$mysqli){
    die("ERROR".mysql_connect_error());
}
?>