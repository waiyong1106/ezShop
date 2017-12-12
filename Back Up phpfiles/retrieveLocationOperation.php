<?php

$servername = "localhost"; 
$username = "root";  
$password = "";  
$db="ezshop";

$con=mysqli_connect($servername,$username,$password,$db) or die('Unable to connect');


if(mysqli_connect_error($con))
{
	echo "Failed to Connect to Database ".mysqli_connect_error();
}
$query = "SELECT count(*) FROM location";

$qresult = mysqli_query($con,$query);
$row = mysqli_fetch_assoc($qresult);
$count = $row["count(*)"];
echo $count;



?>