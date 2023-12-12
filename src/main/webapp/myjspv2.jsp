<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">
<c:import var="block0" url="http://localhost:8080/MyWeb/blockStyle/block0.html"></c:import>
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

<body>
	
    <div id="fullview">
        <div class="block " id="bar">
        	<div class="Row"id="mybtn0" onclick="jstl(0)">
                <img src="/MyWeb/pic/block0.png" alt="">
        	</div>
            <div class="Row"id="mybtn1" onclick="getMethod(1)">
                <img src="/MyWeb/pic/block1.png" alt="">
            </div>
            <div class="Row"id="mybtn2" onclick="getMethod(2)">
                <img src="/MyWeb/pic/block2.png" alt="">
            </div>
            <div class="Row"id="mybtn3" onclick="getMethod(3)">
                <img src="/MyWeb/pic/block3.png" alt="">
            </div>
        </div>


        <div class="block" id="view">
            
        </div>

    </div>
    <script type="text/javascript">
    console.log("a");
    	document.getElementById("view").innerHtml="${block0 }";
	
	</script>
    
</body>

</html>