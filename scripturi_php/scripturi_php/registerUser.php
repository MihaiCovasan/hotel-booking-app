<?php
require "conn_php.php";

$firstName = $_POST["firstname"];
$lastName = $_POST["lastname"];
$password = $_POST["password"];
$email = $_POST["email"];
$checkEmail = $_POST["email"];
$phone = $_POST["phone"];
$gdpr = $_POST["gdpr"];
$cnp = $_POST["cnp"];

$mysqli_query1 = "select email from user where email = '$checkEmail'";

$result=mysqli_query($conn,$mysqli_query1);

      if (mysqli_num_rows($result) > 0) {
        
        $row = mysqli_fetch_assoc($result);
        if($checkEmail===isset($row['email']))
        {
		$r = "email already exists";	
            	print json_encode($r); 
        }
	}
else{

$mysqli_query = "INSERT INTO user(firstname,lastname,password,email,phone,gdpr,cnp) VALUES ('$firstName','$lastName','$password','$email','$phone','$gdpr','$cnp')";
$result2 = mysqli_query($conn,$mysqli_query);

if($result2){
print("Your have registered!"); 
}
else{
print("NOT Successful"); 
}
}


?>