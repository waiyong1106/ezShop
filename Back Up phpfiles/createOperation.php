<?PHP
include_once("connection.php");
if(isset($_POST['txtLocationID']) && isset($_POST['txtCloseTime']) && isset($_POST['txtOpenTime'])&& isset($_POST['txtDayOfWeek'])){
	

	$openTime = $_POST['txtOpenTime'];
	$closeTime = $_POST['txtCloseTime'];
    	$DayOfWeek = $_POST['txtDayOfWeek'];
	$locationID = $_POST['txtLocationID'];
/* 	
	$query ="select * from location where locationAddress='$locationAddress'";
	$result=mysqli_query($conn,$query); */
			
	$sql = "INSERT INTO shopOperation(dayOfWeek,openTime,closeTime,locationID)
	VALUES(?,?,?,?)"; 
	$stmt = $conn->prepare($sql);
	$stmt->bind_param("ssss", $DayOfWeek, $openTime, $closeTime,$locationID);
	$stmt->execute();
		
	if($sql){
	echo "success";
		}else{
	echo "failed";
	exit;
		}	
	
}

?>

<html>
<head><title>Create Operation</title></head>
    <body>
        <h1>Insert Location</h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
			
	
		dow <input type="text" name="txtDayOfWeek" value="" /><br/>
			
		ST <input type="text" name="txtOpenTime" value="" /><br/>
			
        ET <input type="text" name="txtCloseTime" value="" /><br/>
			
		Location ID <input type="text" name="txtLocationID" value="" /><br/>

            <input type="submit" name="btnSubmit" value="Create"/>
        </form>
    </body>
</html>
