function getMethod(type){
    	let gettype = 'MyServlet?type='+type;
    	
		document.getElementById("view").innerHTML="";
        var xhr = new XMLHttpRequest();
        xhr.open('GET', gettype, true);
		//用get方法連接servlet,type決定樣式
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // 在這裡處理成功的回應
                var resultElement = document.getElementById("view");
                resultElement.innerHTML = xhr.responseText;//將接收到的html插入view中
            }
        };
		console.log(gettype)
        xhr.send();
        
        
    }