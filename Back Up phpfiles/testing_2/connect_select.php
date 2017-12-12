<?php

$servername = "localhost"; 
$username = "root";  
$password = "";  
$dbname = "ezshop";
// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql="select * from reviewarating";

$result = mysqli_query($conn,$sql);

if($result){
	while($row= mysqli_fetch_array($result)){
		$flag[]=$row;
	}
	print(json_encode($flag));
}

mysqli_close($conn);
?>