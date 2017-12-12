<?php
	require_once '../android_ezshop/DbOperations.php';
	$response = array();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		if(isset($_POST['email']) and isset ($_POST['password'])){
			$db = new DbOperations();
			
			if($db->userLogin($_POST['email'],$_POST['password'])){
				$user = $db->getUserByEmail($_POST['email']);
				$response['error'] = false;
				$response['id'] = $user['memberID'];
				$response['email'] = $user['email'];
			}else{
				$response['error']=true;
				$response['message']="Invalid email or password";
			}
		}else{
		$response['error']=true;
		$response['message']="Required fields are missing";
		}
	}
	echo json_encode($response);