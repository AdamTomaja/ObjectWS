ObjectWS = function(endpointUrl, onOpenCallback) {
	var $this = this;
	
	$this.objects = {};
	
	console.log("Creating new ObjectWS on url : " + endpointUrl);
	
	var objectwsReceiver = {
			"receiveError": function(request) {
				console.error("Error received: ", request);
			}
		};
	
	$this.ws = new WebSocket(endpointUrl);
	
	$this.ws.onopen = function(event) {
		console.log("Connection opened");
		onOpenCallback();
	}
	
	$this.ws.onclose = function(event) {
		console.log("Connection closed");
	}
	
	$this.ws.onmessage = function(message) {
		var request = JSON.parse(message.data);
		var objects = $this.objects;
		
		var object = objects[request.object];
		if(!object) {
			$this.execute("objectws", "receiveError", ["Cannot find the object: " + request.object]);
			return;
		}
		
		if(!object[request.method]) {
			$this.execute("objectws", "receiveError", ["Cannot find the methid: " + request.method]);
			return;
		}
		
		object[request.method](request);
	}
	
	$this.execute = function(path, method, parameters) {
		$this.ws.send(JSON.stringify({
			'object': path,
			'method': method,
			'parameters': parameters
		}));
	}
	
	$this.registerObject = function(name, object) {
		$this.objects[name] = object;
	}
	
	$this.registerObject("objectws", objectwsReceiver);
}