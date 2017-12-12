<?php
	require_once '../android_ezshop/DbOperations.php';
	$response = array();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		if(isset($_POST['name'])and isset($_POST['dob'])and isset($_POST['phone'])and isset($_POST['address'])and isset($_POST['ic'])and isset($_POST['email'])and isset($_POST['password'])){
		
		$db = new DbOperations();
		$result = $db->createUser($_POST['name'],$_POST['dob'],$_POST['phone'],$_POST['address']
	    ,$_POST['ic'],$_POST['email'],$_POST['password']);
		
		if($result == 1){
		$response['error']=false;
		$response['message']="User Registered Successfully";
		}elseif($result == 2){
		$response['error']=true;
		$response['message']="Error Occured Please Try Again";	
		}elseif($result==0){
		$response['error']=true;
		$response['message']="You are already registered, Please choose a different email";	
		}
			
	}else{
		$response['error']=true;
		$response['message']="Required fields are missing";
		}
	}else{
		$response['error']=true;
		$response['message']="Invalid Request";
	}
	
	echo json_encode($response);