<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="script.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</head>
<c:import url="/websource/blockStyle/block0.html" var="block0"></c:import>
<c:import url="/websource/blockStyle/block1.html" var="block1"></c:import>
<c:import url="/websource/blockStyle/block2.html" var="block2"></c:import>
<c:import url="/websource/blockStyle/block3.html" var="block3"></c:import>
<body>
    <div id="fullview">
        <div class="block " id="bar">
        	<div class="Row">
                <a href="?type=0" >
                <img src="/MyWeb/pic/block0.png" alt="">
        		</a>
        	</div>
            <div class="Row">
                 <a href="?type=1">
                <img src="/MyWeb/pic/block1.png" alt="">
            	</a>
            </div>
            <div class="Row">
                 <a href="?type=2">
                <img src="/MyWeb/pic/block2.png" alt="">
            	</a>
            </div>
            <div class="Row">
                
	            <a href="?type=3">
	                <img src="/MyWeb/pic/block3.png" alt="">
	            </a>
            </div>
        	
           
           
        </div>


        <div class="block" id="view">
            <c:choose>
            	<c:when test="${param.type == '0'}">${block0 }</c:when>
            	<c:when test="${param.type == '1'}">${block1 }</c:when>
            	<c:when test="${param.type == '2'}">${block2 }</c:when>
            	<c:when test="${param.type == '3'}">${block3 }</c:when>
            	<c:otherwise>${block0 }</c:otherwise>
            
            </c:choose>
        </div>

    </div>
    <script>
    	
    
	
    </script>


</body>

</html>