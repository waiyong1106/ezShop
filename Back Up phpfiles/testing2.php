<?PHP
include_once("connection.php");
if(isset($_POST['txtLocationID'])){
	

	$locationID = $_POST['txtLocationID'];
	$query ="select rating,review,rrDate from reviewarating where locationID=$locationID";
	$result=mysqli_query($conn,$query); 
			
	//*$sql = "INSERT INTO shopOperation(dayOfWeek,openTime,closeTime,locationID)
	//*VALUES(?,?,?,?)"; 
	
	/* $stmt = $conn->prepare($query);
	$stmt->bind_param("i",$locationID);
	$stmt->execute(); */
		
	if($result=mysqli_query($conn,$query)){	
	if($query){
	while($rows = mysqli_fetch_assoc($result)) {
    echo "<option value='".$locationID."'>".$rows['review'].$rows['rrDate'].$rows['rating']."</option>";
		}
		}else{
			
	echo "failed";
	exit;
		}	
	}else{
		echo "nothing found";
		exit;
	}
}

?>

<html>
<head><title>Create Operation</title></head>
    <body>
        <h1>Insert Location</h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
			
		Location ID <input type="text" name="txtLocationID" value="" /><br/>

            <input type="submit" name="btnSubmit" value="Create"/>
        </form>
    </body>
</html>
