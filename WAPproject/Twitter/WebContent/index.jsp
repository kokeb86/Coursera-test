<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>

	<ul>
	  <li id="romance"> <a >Romance</a></li>
	  <li id="comedy"> <a >Comedy</a></li>
	  <li id="scifiction"> <a>SCI-Fiction</a></li>
	  <li id="sitcome"> <a>Sitcome</a></li>
	  <li id="seetrends"><a>See Trends</a></li>
	</ul>
	
	<br /> 
	<br /> 
		 
		 
		 
	<div id="twittertable">
	<c:forEach var="item" items="${categoryList}" varStatus="counter" >
		
		 <div class="item">
        <img id="image" src="${item.image}" alt="item1" >
         <span class="caption"><a href="${item.link}">${item.content}</a></span>
         </div>
		
	</c:forEach>
	</div>
	
	<div id="trendtable">
	<c:forEach var="item" items="${trendList}" varStatus="counter" >
		
		 <div class="item">
       		<span> <a href="${item.url}"> ${item.name }</a></span>
         </div>
	</c:forEach>
	</div>

	
	
	<div id="footer">Twitter App by Loc,kokeb & Rufael on Sept 28/2016</div>
		
</body>
</html>