<?PHP
include_once("connection.php");
if(isset($_POST['txtLocationID'])){

	$locationID = $_POST['txtLocationID'];
	$query ="select count(*)from reviewarating where locationID=$locationID";
	$result=mysqli_query($conn,$query); 
		
	if($result=mysqli_query($conn,$query)){	
			if($query){
	$result = mysqli_fetch_array($result);
	echo $result[0];
				
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
