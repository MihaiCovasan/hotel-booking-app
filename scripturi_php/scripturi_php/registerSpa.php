<?php
require "conn_php.php";

$iduser = $_POST["iduser"];
$startdate = $_POST["startdate"];
$enddate = $_POST["enddate"];
$price = $_POST["price"];
$numberofperson = $_POST["numberofperson"];
$checkout =  $_POST["checkout"];
$checkiduser =  $_POST["iduser"];

$mysqli_query1 = "select checkout from reservationspa r,user u where u.iduser = r.iduser and u.iduser = '$iduser' and r.checkout = '1'";

$result=mysqli_query($conn,$mysqli_query1);

      if (mysqli_num_rows($result) > 0) {
        
        //$row = mysqli_fetch_assoc($result);
	//$a = $row['checkout'];
	//$b = '1';
	//print ($a); 
        //if($a == $b)
        //{
		$r = "exist allready a reservation!";	
            	print json_encode($r); 
       // }
	}
else{

$mysqli_query = "INSERT INTO reservationspa(iduser,startdate,enddate,price,numberofperson,checkout) VALUES ('$iduser','$startdate','$enddate','$price','$numberofperson','$checkout')";
$result2 = mysqli_query($conn,$mysqli_query);

if($result2){
print("Your have registered spa!"); 
}
else{
print("NOT Successful registered spa!"); 
}
}


?>