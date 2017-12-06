package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import registry.PeerRegistry;

@RestController
public class RestApi {
	
	@Autowired
	public RestApi() {
	}
	
	@RequestMapping("/greeting")
	public String echo() {
		System.out.println("greeting");
		return "test";
	}
	
	@RequestMapping("/consume")
	public Integer consumeThing() {
		RestTemplate restTemplate = new RestTemplate();
        Integer status = restTemplate.getForObject("http://46.101.28.25:8080/latest", Integer.class);
        return status;
        
	}
	
	@RequestMapping("/pingFriends")
	public String pingFriends() {
		RestTemplate restTemplate = new RestTemplate();
		List<String> peers = PeerRegistry.getRegistry();
		for (String peer : peers) {
			String status = restTemplate.getForObject(peer+"/greeting", String.class);
		}
        return "done";
	}
}
