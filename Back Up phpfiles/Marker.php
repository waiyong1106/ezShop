<?php 
	$server		= "localhost"; 
	$user		= "root"; 
	$password	= ""; 
	$database	= "ezshop"; 
	
	$con = mysqli_connect($server, $user, $password, $database);
	if (mysqli_connect_errno()) {
		echo "Fail to Connect MySQL: " . mysqli_connect_error();
	}
	$query = mysqli_query($con, "SELECT * FROM location ORDER BY locationName ASC");
	$json = '{"location": [';

	while ($row = mysqli_fetch_array($query)){

		$char ='"';

		$json .= 
		'{
			"LocationID":"'.str_replace($char,'`',strip_tags($row['locationID'])).'", 
			"LocationName":"'.str_replace($char,'`',strip_tags($row['locationName'])).'",
			"LocationCategory":"'.str_replace($char,'`',strip_tags($row['locationCategory'])).'",
			"Latitude":"'.str_replace($char,'`',strip_tags($row['Latitude'])).'",
			"Longtitude":"'.str_replace($char,'`',strip_tags($row['Longtitude'])).'"
		},';
	}

	$json = substr($json,0,strlen($json)-1);

	$json .= ']}';

	echo $json;
	
	mysqli_close($con);
	
?>