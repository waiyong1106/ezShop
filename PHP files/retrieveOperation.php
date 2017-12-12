<?PHP 
include_once("connection.php");
if(isset($_GET['format']) && $_GET['format'] == "json"){
	
$stmt = "SELECT * FROM shopoperation";

$result = $conn->query($stmt);

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $output[]=$row;
    }
	echo json_encode($output);
    
} else {
    echo 'no item';
}
}
?>