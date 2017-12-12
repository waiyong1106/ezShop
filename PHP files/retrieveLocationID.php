<?PHP
include_once("connection.php");
if(isset($_POST['txtLocationID'])){
	 $count = 0;
	 $finalDouble = 0;
	 $finalValue= 0;
	$locationID = $_POST['txtLocationID'];
	$query ="select rating,review,rrDate from reviewarating where locationID=$locationID";
	$result=mysqli_query($conn,$query); 
			

		
	if($result=mysqli_query($conn,$query)){	
	if($query){
	while($rows = mysqli_fetch_assoc($result)) {
	$finalDouble = $finalDouble+($rows['rating']*1);
	$count= $count+1;
	}
	if($count != 0){
		$finalValue = $finalDouble/$count;
		echo $finalValue;	
	exit;
	}else 
		echo "no review and rating :<";
	exit;
	
	
	
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
