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
<div class="login">
	<div class="wrap">
		<div class="col_1_of_login span_1_of_login">
		</div>
		<div class="col_1_of_login span_1_of_login">
			<div class="login-title">
				<h4 class="title">Sign in to start your session</h4>
				<div class="comments-area">
					<form action="login" method="post">
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
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>