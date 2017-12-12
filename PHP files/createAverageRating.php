<?PHP 
include_once("connection.php");
if( isset($_POST['txtRating']) && isset($_POST['txtLocationID'])){
	
	$rarRating = $_POST['txtRating'];
	$locationID = $_POST['txtLocationID'];

			 
	$sql = "Update location set averageRating =? where locationID = ?";
	$stmt = $conn->prepare($sql);
	$stmt->bind_param("ss", $rarRating, $locationID);
	$stmt->execute();

		if($sql){
			echo "insert success";
				exit;
		}else{
			echo "failed";
			exit;
		}	
}

?>

<html>
<head><title>Insert data</title></head>
    <body>
        <h1>Insert Location/Review/Rating</h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
			
			Rating <input type="text" name="txtRating" value="" /><br/>
			
			Location <input type="text" name="txtLocationID" value="" /><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>
