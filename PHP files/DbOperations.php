<?php
	
	class DbOperations{
		private $con;
		
		function __construct(){
			require_once ("DbConnect.php");
			$db = new DbConnect();
			$this->con = $db->connect();
		}
		
		public function createUser($name,$dob,$phone,$address,$ic,$email,$password){
			if($this->isUserExist($email)){
				return 0;
			}else{
			//$pass = md5($password);
			$stmt = $this->con->prepare("INSERT INTO `member` (`memberID`, `name`, `dob`, `phone`, `address`, `ic`, `email`, `password`)
			VALUES(NULL,?,?,?,?,?,?,?);");
			$stmt->bind_param("sssssss",$name,$dob,$phone,$address,$ic,$email,$password);
			if($stmt->execute()){
				return 1;
				
			}else{
				return 2;
			}
			
			}
			
		}
		public function userLogin($email,$password){
			//$password = md5($pass);
			$stmt = $this->con->prepare("SELECT memberID FROM member WHERE email = ? AND password = ?");
			$stmt->bind_param("ss",$email,$password);
			$stmt->execute();
			$stmt->store_result();
			return $stmt->num_rows>0;
		}
		public function getUserByEmail($email){
			$stmt = $this->con->prepare("SELECT * FROM member WHERE email = ?");
			$stmt->bind_param("s",$email);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}
		private function isUserExist($email){
			$stmt = $this->con->prepare("SELECT memberID FROM member WHERE email = ?");
			$stmt->bind_param("s",$email);
			$stmt->execute();
			$stmt->store_result();
			return $stmt->num_rows > 0;
			
		}
	}
			