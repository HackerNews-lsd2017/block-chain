package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
	
	@Autowired
	public RestApi() {
	}
	
	@RequestMapping("/greeting")
	public String echo() {
		
		return "test";
	}
}
