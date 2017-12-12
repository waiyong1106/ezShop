<?PHP
include_once("connection.php");
if( isset($_POST['txtLocationName']) && isset($_POST['txtLocationAddress'])){
	
	$locationName = $_POST['txtLocationName'];
    $locationAddress = $_POST['txtLocationAddress'];
	$locationCategory = $_POST['txtLocationCategory'];
	$locationDescription = $_POST['txtLocationDescription'];
	$locationOwner = $_POST['txtLocationOwner'];
	$locationEmailAddress = $_POST['txtLocationEmailAddress'];
	$locationContact =$_POST['txtLocationContact'];
	$Latitude = $_POST['txtLatitude'];
	$Longtitude = $_POST['txtLongtitude'];
	$averageRating = 0.0;
	$query ="select * from location where locationAddress='$locationAddress'";
	if($result=mysqli_query($conn,$query))
	{
		if(mysqli_num_rows($result)>0)
		{
			echo "location is exist";
			exit;
		}
		else
			echo ", insert to database now.";
			$sql = "INSERT INTO Location(locationName,locationAddress,locationCategory,locationDescription, locationOwner,locationEmailAddress,locationContact,Latitude,Longtitude,averageRating)
			VALUES(?,?,?,?,?,?,?,?,?,?)"; 
			$stmt = $conn->prepare($sql);
			$stmt->bind_param("sssssssddd", $locationName, $locationAddress,$locationCategory,$locationDescription
			,$locationOwner,$locationEmailAddress,$locationContact,$Latitude,$Longtitude,$averageRating);
			$stmt->execute();
	
	if($stmt->fetch()){
	   echo "stmtFailed";
      exit;
    }else{
		 echo "Success";
	  exit;
     
	}		
	}
	else
		echo "failed";
	
}

?>

<html>
<head><title>Insert location</title></head>
    <body>
        <h1>Insert Location</h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
        Location Name <input type="text" name="txtLocationName" value="" /><br/>
			
        Location Address <input type="text" name="txtLocationAddress" value="" /><br/>
	
	    Location Category <input type="text" name="txtLocationCategory" value="" /><br/>
		
		Location Description <input type="text" name="txtLocationDescription" value="" /><br/>
		 
		Location Owner <input type="text" name="txtLocationOwner" value="" /><br/>
		  
		Location Email Address <input type="text" name="txtLocationEmailAddress" value="" /><br/>
		   
		Location Contact <input type="text" name="txtLocationContact" value="" /><br/>
		
		Latitude <input type="text" name="txtLatitude" value="" /><br/>
		
		Longtitude <input type="text" name="txtLongtitude" value="" /><br/>

            <input type="submit" name="btnSubmit" value="Create"/>
        </form>
    </body>
</html>
