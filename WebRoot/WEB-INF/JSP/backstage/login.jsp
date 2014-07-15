<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
  </head>
  
  <body>
    <div class="container">
          <div class="row">
              <div class="col-md-4"></div>
              <div class="col-md-4">

                  <form class="form-signin" method="post" action="backstage/auth.do">
                      <h2 class="form-signin-heading">Please sign in</h2>
                      <input type="username" class="form-control" name="username" required autofocus>
                      <input type="password" class="form-control" name="password" required>
                      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                  </form>

              </div>
              <div class="col-md-4"></div>
          </div>


      </div>

      <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
      <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>
