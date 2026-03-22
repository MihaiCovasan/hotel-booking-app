<?php

require "conn_php.php";
$email = $_POST["email"];
$password = $_POST["password"];


$sql = ("SELECT * FROM user WHERE email='$email' AND password='$password'");

$result = mysqli_query($conn,$sql);

if(mysqli_num_rows($result)>0){
print("Login success");
}
else{
print("Login not succes"); 
}

?>