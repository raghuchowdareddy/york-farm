<!doctype html>
<html>
<head>
	<title>York Farm | Security</title>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
	<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
	<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css" />
	<link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css" />
</head>
<body>
	<div class="hold-transition login-box">
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>
			<form name="form" action="authenticate" role="form" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="Username" name="username" required="required" />
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Password" name="password" required="required" />
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8"><#--<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>--></div>
					<div class="col-xs-4"><button type="submit" class="btn btn-primary">Sign In</button></div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="resources/plugins/fastclick/fastclick.min.js"></script>
	<script type="text/javascript" src="resources/dist/js/app.min.js"></script>
	<script type="text/javascript" src="resources/dist/js/demo.js"></script>
	<script type="text/javascript" src="resources/plugins/iCheck/icheck.min.js"></script>
</body>
</html>