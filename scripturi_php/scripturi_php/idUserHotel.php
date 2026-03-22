<?php

require "conn_php.php";
$email = $_POST["email"];
$password = $_POST["password"];

$mysqli_query = ("SELECT iduser FROM user where email ='$email' and password = '$password'");


$i = mysqli_query($conn,$mysqli_query);

while($row = mysqli_fetch_array($i))
{

$r[]=$row;

}
print json_encode($r);
print("Login success");
?>




