<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Profile</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="styles.css">
	</head>
	<body id="thebody" style="background-color: black;">
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
      					<li class="active"><a href="profile.jsp">Profile</a></li>
      					<li><a href="http://localhost:8080/Struts2Twitter/logout.action">Log Out</a>
       				</ul>
    			</div><!-- /.navbar-collapse -->
  			</div><!-- /.container-fluid -->
		</nav>
		<div class="page-header container">
  			<h1 style="color: blue;"><s:property value="username"/>'s Tweets <small style="color: #8080ff">Memphis, TN</small></h1>
  			<button type="button" id="editBtn" style="float: right;" class="btn btn-default">Delete Tweets</button>
		</div>
		
		<div id="tweets" class="container">
			<ul id="tweetList" class="list-group">
				<s:if test="tweets.isEmpty()">
					<li class="list-group-item">Go ahead and send your first tweet!</li>
				</s:if>
				<s:else>
					<s:iterator value="tweets" >
						<li class="list-group-item"><s:property value="message"/><span id="glyph" style="color: red" class="glyphicon glyphicon-remove glyph"></span></li>
					</s:iterator>
				</s:else>
			</ul>
			
			<s:form id="sendTweet" action="tweet" theme="simple">
				<div id="enterTweet" class="input-group col-lg-6">
				<s:textfield key="message" id="message" label="Enter Tweet" class="form-control" placeholder="Enter tweet..."/>
				<span class="input-group-btn"><s:submit id="submit" class="btn btn-default" /></span>
				</div>
			</s:form>
		</div>
		<div style="height: 50px;"></div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script type="text/javascript" src="scripts.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	</body>
</html>