ObjectWS = function(endpointUrl, onOpenCallback) {
	var $this = this;
	
	$this.objects = {};
	
	console.log("Creating new ObjectWS on url : " + endpointUrl);
	
	$this.ws = new WebSocket(endpointUrl);
	
	$this.ws.onopen = function(event) {
		console.log("Connection opened");
		onOpenCallback();
	}
	
	$this.ws.onclose = function(event) {
		console.log("Connection closed");
	}
	
	$this.ws.onmessage = function(message) {
		console.log("Message received", message.data);
		var request = JSON.parse(message.data);
		console.log(request);
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
}