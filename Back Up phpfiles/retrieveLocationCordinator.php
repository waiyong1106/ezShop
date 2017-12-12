<?php
$servername = "localhost"; 
$username = "root";  
$password = "";  
$db="ezshop";

// Create connection
$conn = new mysqli($servername, $username, $password, $db);

if ($conn->connect_error) {
 
 die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT locationID,locationName,locationContact,locationAddress, latitude,longtitude, locationCategory, locationDescription ,averageRating from location";

$result = $conn->query($sql);

if ($result->num_rows >0) {
 
 
 while($row[] = $result->fetch_assoc()) {
 
 $tem = $row;
 
 $json = json_encode($tem);
 
 
 }
 
} else {
 echo "No Results Found.";
}
 echo $json;
$conn->close();
?>