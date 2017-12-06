package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import datastructures.SampleClass;

@RestController
public class RestApi {
	
	@Autowired
	public RestApi() {
	}
	
	@RequestMapping("/greeting")
	public String echo() {
		
		return "test";
	}
	
	@RequestMapping("/consume")
	public Integer consumeThing() {
		RestTemplate restTemplate = new RestTemplate();
        Integer status = restTemplate.getForObject("http://46.101.28.25:8080/latest", Integer.class);
        return status;
        
	}
}
