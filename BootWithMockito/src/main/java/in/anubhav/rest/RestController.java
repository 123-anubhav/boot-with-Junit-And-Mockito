package in.anubhav.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import in.anubhav.service.MessageService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private MessageService msgService;

	@GetMapping("/greet")
	public ResponseEntity greetMessage() {
		
		String response = msgService.getMessage();
		
		return new ResponseEntity(response, HttpStatus.OK);
	}
}
