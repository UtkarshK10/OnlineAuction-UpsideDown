<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>


<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">


<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="main">

		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign Up</h2>
					
						<form method="POST" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Name" />
							</div>
							<div class="form-group">
								<label for="dob"><i class="zmdi zmdi-calendar"></i></label> <input
									type="date" name="dob" id="dob" placeholder="Date Of Birth" onblur="validateAge()"  />
									<span style="color:red" id="ageerror"></span>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Email" />
									
							</div>
							
							<div class="form-group form-button"><input type="button" value="Set Email as Username" onclick="myFunction()"></div>
							<div class="form-group">
								<label for="phoneNumber"><i class="zmdi zmdi-phone-msg"></i></label> <input
									type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone Number" />
							</div>
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username" placeholder="Username" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-home"></i></label> <input
									type="text" name="address" id="address" placeholder="Address" />
							</div>
							
							<div class="form-group">
								<label for="userType"></label> 
									<select class ="form-group" name="userType" id="userType" required>
										 <option value="">Register as a buyer or seller</option>
							              <option value="0">Buyer</option>
							              <option value="1">Seller</option>
						            </select>
							</div>
											
							<div class="form-group">
								<label for="walletAmt"><i
									class="zmdi zmdi-balance-wallet"></i></label> <input
									type="text" name="walletAmt" id="walletAmt" placeholder="Wallet Amount" />
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script type="text/javascript">
	function myFunction() {
	    document.getElementById("username").value = document.getElementById("email").value;
	}
	
	function calculate_age(dob) { 
	    var diff_ms = Date.now() - dob.getTime();
	    var age_dt = new Date(diff_ms); 
	  
	    return Math.abs(age_dt.getUTCFullYear() - 1970);
	}
	
	function validateAge(){
		var birthday = document.getElementById('dob');
		var dob = new Date(birthday.value);
	    var month = dob.getMonth(); 
		var day   = dob.getDate();
		var year  = dob.getFullYear(); 
		var ans = calculate_age(new Date(year,month,day));

		if(ans<21){
			document.getElementById("ageerror").innerHTML="Age less than 21 not allowed";
		}
		
	}
	
	
	</script>


</body>
</html>