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


$sql="SELECT * FROM reviewarating";


$result=mysqli_query($con,$sql);
if($result)
{
	while($row=mysqli_fetch_array($result))
	{
		$flag[]=$row;
	}
	
	print(json_encode($flag));
	
}

mysqli_close($con);

?>