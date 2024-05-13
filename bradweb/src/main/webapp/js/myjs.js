window.onload = function(){
	let start = document.getElementById("start");
	let mesgDiv = document.getElementById("mesgDiv");
	let mesg = document.getElementById("mesg");
	let send = document.getElementById("send");
	let log = document.getElementById("log");
	
	let webSocket;
	
	start.addEventListener("click", function(){
		connect();
	});
	
	send.addEventListener("click",function(){
		
		webSocket.send("haha");
	});
	
	start.style.display = "block";
	mesgDiv.style.display = "none";
	
	function connect(){
		webSocket = new WebSocket("ws://localhost:8080/bradweb/myserver");
		webSocket.onerror = function(){
			console.log("ERROR");
			start.style.display = "block";
			mesgDiv.style.display = "none";
		};
		
		webSocket.onopen = function(){
			console.log("OPEN");
			start.style.display = "none";
			mesgDiv.style.display = "block";			
		};
		webSocket.onclose = function(){
			console.log("CLOSE");
			start.style.display = "block";
			mesgDiv.style.display = "none";
			
		};
		webSocket.onmessage = function(){};
	}
	
	
	
}
