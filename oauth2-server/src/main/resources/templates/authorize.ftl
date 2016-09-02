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
<div class="container">
   	<h2>Please Confirm</h2>
    <p>Do you authorize "${authorizationRequest.clientId}" at "${authorizationRequest.redirectUri}" to access your protected resources with scope ${authorizationRequest.scope?join(", ")}.</p>
    <form id="confirmationForm" name="confirmationForm" action="oauth/authorize" method="post">
       	<input name="user_oauth_approval" value="true" type="hidden"/>
       	<input name="scope.openid" value="true" type="hidden"/>
       	<#--<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
       	<button class="btn btn-primary" type="submit">Approve</button>
   	</form>
   	<form id="denyForm" name="confirmationForm" action="oauth/authorize" method="post">
       	<input name="user_oauth_approval" value="false" type="hidden"/>
       	<#--<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
       	<button class="btn btn-primary" type="submit">Deny</button>
   	</form>
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