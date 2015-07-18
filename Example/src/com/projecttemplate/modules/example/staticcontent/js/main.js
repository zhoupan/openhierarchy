/**
 * Index module main file 
 */
$(document).ready(function() {
	
	var modulePath = $('#modulePath').val();
	
	requestHandler.get({ queryId: '1' },  modulePath + 'getSomeData', true, undefined, function(result) {
		
		// Just for visualization!
		setTimeout(function() {
			$res = $('p.result');
			if(result.success === 1)
				$res.html("Request success! Width queryId: " + result.queryId + ". Goal was added to db: " + result.goalType);
			else {
				$res.html("Request was a failure!");
			}
			
		}, 3000);
	});
	
	
});
