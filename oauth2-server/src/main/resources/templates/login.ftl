<!DOCTYPE html>
<html lang="en">
<head>
<title>York Farm | Secuirty</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="header-top">
	<div class="wrap">
		<div class="logo"><a href="#"><img src="resources/images/logo.png" /></a></div>
		<div class="cssmenu">
		   <ul>
			 <li><a href="#">Store Locator</a></li>
			 <li><a href="/login">My Account</a></li>
			 <li><a href="#">CheckOut</a></li> 
		   </ul>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div class="header-bottom">
	<div class="wrap">
		<ul class="megamenu skyblue">
			<li><a class="color1" href="#">Home</a></li>
			<li><a class="color2" href="#">Flowers</a></li>
			<li><a class="color3" href="#">Fruits</a></li>
			<li><a class="color4" href="#">Vegetables</a></li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="login">
		<div class="wrap">
			<div class="col_1_of_login span_1_of_login">
			
			</div>
			<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
					<h4 class="title">Registered Customers</h4>
					<div class="comments-area">
						<form>
							<p><label>Username</label><span>*</span><input type="text" /></p>
							<p><label>Password</label><span>*</span><input type="password" /></p>
							<p><#--<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>--></p>
							<p><input type="submit" value="Login" /></p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="footer">
	<div class="copy">
		<div class="wrap">
			<p>&copy; All rights reserved | Template by&nbsp;<a href="http://enuminfo.com/"> ENUMInfo</a></p>
		</div>
	</div>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
<script type="text/javascript" src="https://code.angularjs.org/1.5.0/angular-route.js"></script>
<script type="text/javascript" src="https://code.angularjs.org/1.5.0/angular-cookies.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
<script type="text/javascript">
jQuery(document).ready(function($) {
	$(".scroll").click(function(event) {
		event.preventDefault();
		$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
	});
});
</script>
<script type="text/javascript" src="resources/app.js"></script>
</body>
</html>