<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	</head>
	<body style="background-image: url(MSbridge.jpg); background-size: 100%; background-repeat: no-repeat; background-position: center;">
		<nav class="navbar navbar-inverse">
  			<div class="container-fluid">
    			<!-- Brand and toggle get grouped for better mobile display -->
    			<div class="navbar-header">
      				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        				<span class="sr-only">Toggle navigation</span>
        				<span class="icon-bar"></span>
        				<span class="icon-bar"></span>
        				<span class="icon-bar"></span>
      				</button>
      				<a class="navbar-brand" href="profile.jsp">Faux Twitter</a>
    			</div>

    			<!-- Collect the nav links, forms, and other content for toggling -->
    			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      				<ul class="nav navbar-nav">
      				</ul>
      				<ul class="nav navbar-nav navbar-right">
      					<li><a href="register.jsp">Register</a></li>
        				<form class="navbar-form navbar-left" role="search">
        					<div class="form-group">
          						<input type="text" class="form-control" placeholder="Search">
        					</div>
        					<button type="submit" class="btn btn-default">Submit</button>
      					</form>
     				</ul>
    			</div><!-- /.navbar-collapse -->
  			</div><!-- /.container-fluid -->
		</nav>
		<s:div id="loginDiv">
			<s:form action="login">
				<s:textfield id="username" key="username" label="Username" class="form-control"/><br/>
				<s:password id="password" key="password" label="Password" class="form-control"/><br/>
				<s:submit id="submitButton" class="btn btn-default"/>
			</s:form>
		</s:div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	</body>
</html>