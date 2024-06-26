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
		let message = {
			message: mesg.value
		};
		webSocket.send(JSON.stringify(message));
	});
	
	start.style.display = "block";
	mesgDiv.style.display = "none";
	
	function connect(){
		webSocket = new WebSocket("ws://10.0.103.50:8080/bradweb/myserver");
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
		webSocket.onmessage = function(event){
			console.log(event);
			let mesgObj = JSON.parse(event.data);
			log.innerHTML += mesgObj.message + "<br />";
		};
	}
	
	
	
}
