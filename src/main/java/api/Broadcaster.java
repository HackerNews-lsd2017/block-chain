package api;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import datastructures.Transaction;
import registry.PeerRegistry;

public class Broadcaster {

	private AppConfig config = new AppConfig();
	private List<String> peers = PeerRegistry.getRegistry();
	
	public void broadcastPingFriends(int timeout) {
		RestTemplate restTemplate = config.getRestTemplateWithTimeout(timeout);
		for (String peerUrl : peers) {
			try {
				String status = restTemplate.getForObject(peerUrl+"/greeting", String.class);
			}
			catch(Exception e) {
				System.out.println("Peer "+peerUrl+" does not respond");
			}
			
		}
	}
	
	//When you want to broadcast something else (block or some shit),
	//use below method as example. Everything below is mandatory. Don't try to remove try-catch or you will be fucked
	public void broadcastTransaction(Transaction t, int timeout) {
		//Get template that will time out response if something goes wrong
		RestTemplate restTemplate = config.getRestTemplateWithTimeout(timeout);
		
		//Set the request payload
		HttpEntity<Transaction> request = new HttpEntity<>(t);
		
		//Iterate over all peers
		for (String peerUrl : peers) {
			try {
				// This description corresponds to method below
				//url, request payload, expected return type
				restTemplate.postForObject(peerUrl+"/receive/transaction", request, Boolean.class);
			}
			catch(Exception e) {
				System.out.println("Peer "+peerUrl+" does not respond");
			}
		}
	}
}
