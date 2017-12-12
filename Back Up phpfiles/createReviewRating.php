<?PHP 
include_once("connection.php");
if( isset($_POST['txtRating']) && isset($_POST['txtReview']) && isset($_POST['txtLocationID'])){
	
	$rarRating = $_POST['txtRating'];
   	 $rarReview = $_POST['txtReview'];
	$currentDate = date('Y-m-d');
	$locationID = $_POST['txtLocationID'];
	

	/* 		$query ="select * from location where locationID='$locationID'";
	$result=mysqli_query($conn,$query); */
			 
			$sql = "INSERT INTO reviewarating(rating,review,rrDate,locationID)
			VALUES(?,?,?,?)"; 
			$stmt = $conn->prepare($sql);
			$stmt->bind_param("ssss", $rarRating, $rarReview, $currentDate,$locationID);
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
			
         Review <input type="text" name="txtReview" value="" /><br/>
			
			Location <input type="text" name="txtLocationID" value="" /><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>
