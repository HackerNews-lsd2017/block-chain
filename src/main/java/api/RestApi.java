package api;

import datastructures.Block;
import datastructures.Blockchain;
import datastructures.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import util.Broadcaster;
import util.Manager;

//Pay attention to naming standards
// (/receive or /broadcast) + /className
// for example: /receive/transaction
@RestController
public class RestApi {

	Broadcaster broadcaster = new Broadcaster();

	@Autowired
	public RestApi() {
	}

	@RequestMapping("/greeting")
	public String echo() {
		System.out.println("greeting");
		return "test";
	}

	@RequestMapping(path = "/receive/transaction", method = RequestMethod.POST)
	public Boolean receiveTransaction(@RequestBody Transaction t) {
		// Process the transaction
		// Mine the transaction
		// once mined send it to peers
		System.out.println(t.toString());
		return true;
	}
	
	@RequestMapping(path = "/receive/blockchain", method = RequestMethod.POST)
	public Boolean receiveBlockchain(@RequestBody Blockchain bc) {
		// get the new blockchain and compare lengths with the old one
		System.out.println(bc.toString());
		return true;
	}

	@RequestMapping(path = "/broadcast/block", method = RequestMethod.POST)
	public Boolean broadcastBlock(@RequestBody Block b) {
//		broadcaster.broadcastBlock(b);
		return true;
	}

	@RequestMapping(path = "/broadcast/transaction", method = RequestMethod.POST)
	public Boolean broadcastTransaction(@RequestBody Transaction t) {
		broadcaster.broadcastTransaction(t, 500);
		Manager.addTransaction(t);
		return true;
	}

	@RequestMapping("/consume")
	public Integer consumeThing() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://46.101.28.25:8080/latest", Integer.class);
	}

	@RequestMapping("/pingFriends")
	public String pingFriends() {
		broadcaster.broadcastPingFriends(500);
		return "done";
	}

}
