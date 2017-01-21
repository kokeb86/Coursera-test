<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, wap.com.model.TwitterItem" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content='application/x-www-form-urlencoded; charset=UTF-8'>
<title>WAP Project</title>
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
	
	<table id="tweettable">
	<c:forEach var="item" items="${categoryList}" varStatus="counter" >
		<tr>
		
  
		
			<td class="twitterItem">  
			<div class="w3-container">
				<a class="itemContent" href="${item.link}" > 
				<img class="twitterImage" src="${item.image}" alt="item1" height="300" width="300">
				</a>
				<div class="itemContent">
					${item.content } 
				</div>
			</div>
			</td>
			
		</tr>
	</c:forEach>
	</table>
	
	<table id="trendtable">
	<c:forEach var="item" items="${trendList}" varStatus="counter" >
		<tr>		
			<td class="trendItem">  
				<a class="itemContent" href="${item.link}" > <img class="trendImage" src="${item.image}" alt="item1" height="300" width="300"> <br/> ${item.content } </a>
			</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>