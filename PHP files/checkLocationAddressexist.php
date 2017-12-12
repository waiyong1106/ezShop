<?PHP
include_once("connection.php");
if(isset($_POST['txtLocationAddress'])){

    $locationAddress = $_POST['txtLocationAddress'];
	$query ="select * from location where locationAddress='$locationAddress'";
	
	$result = mysqli_query($conn,$query);
	
	if($result->num_rows > 0){
		if(isset($_POST['mobile']) && $_POST['mobile'] =="android"){
			echo "success";
			exit;
		}
		echo "retrieve success";
	}
	else{
	echo "failed<br/>";
		
	}
	
}


?>

<html>
<head><title>Create Operation</title></head>
    <body>
        <h1>Insert Location</h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
			
		Location ID <input type="text" name="txtLocationAddress" value="" /><br/>

            <input type="submit" name="btnSubmit" value="Create"/>
        </form>
    </body>
</html>
