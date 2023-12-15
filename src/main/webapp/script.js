var blockid;
var barmode = false;
/*function getMethod(type){
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
        
        
    }*/
    
    
function getMethod1(type){
    let src = "websource/blockStyle/block"+type+".html"
    console.log(type)
    $("#view").load(`websource/blockStyle/block${type}.html`)
    
}
 function elmentBar(id){
    blockid=id;
    $("#bar").load("websource/barType/elementBar.html")
    barmode=false;
    
 }


function setelement(id){
    console.log(id+'set')
    $(`#${id}`).html("element")
}

function switchBar(){
    if(barmode==true){
        elmentBar(blockid)
    }
    else{
        $("#bar").load("websource/barType/blockBar.html")
        barmode=true
    }
}
function CarouselElement(id){
    $(`#${id}`).load("websource/elementType/CarouselElement.html")
}
function FormElement(id){
    $(`#${id}`).load("websource/elementType/FormElement.html")
}
function imgElement(id){
	console.log(id);
	var width=$(`#${id}`).innerWidth();
	var height=$(`#${id}`).innerHeight();
	console.log(width+"高"+height);
	 $(`#${id}`).load("websource/elementType/imgUpload.html")
	/*$.get('ImgResize?width=' + width + '&height=' + height,function(data, status){
                if(status=='success'){
                    console.log(data)
                    
                }else{
					console.log("失敗")
				}
            })*/
    
}
function uploadImage() {
            var formData = new FormData();
            formData.append("file", document.getElementById("fileInput").files[0]);
			console.log(blockid);
			var width=Math.floor($(`#${blockid}`).innerWidth());
			var height=Math.floor($(`#${blockid}`).innerHeight());
			var html="";
			//console.log(width+"高"+height);
            $.ajax({
                type: "POST",
                url: 'ImgUpload?width=' + width + '&height=' + height,  
                data: formData,
                contentType: false,
                processData: false,
                success: function(data) {
					var retrytime = 0;
					var img = new Image();
					
					function tryload(){								//強制重新抓取直到抓到
						console.log("trystart")
						img.src ="/MyWeb/pic/"+data;
					img.onload = function() {
        				showpic()
 					 };
    				img.onerror = function() {
       					console.log("load fail")
       					retrytime++
       					if(retrytime<=10000){tryload();console.log(retrytime)}
       					else{return}
       					
    					};
					}
					tryload();
					html = "<img src='/MyWeb/pic/"+data+"' alt='Inserted Image'>"
                    console.log("Image uploaded successfully. Server response: " + data);
						//setTimeout(showpic,3000);
					function showpic(){
						$(`#${blockid}`).html(html)
					}
                    
                },
                error: function(err) {
                    console.log(err);
                }
            });
					 
        }