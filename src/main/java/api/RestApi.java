package api;

import datastructures.Block;
import datastructures.Blockchain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import datastructures.Transaction;
import org.springframework.web.bind.annotation.ResponseBody;

//Pay attention to naming standards
// (/receive or /broadcast) + /className
// for example: /receive/transaction
@RestController
public class RestApi {
        Block block = new Block();
	Broadcaster broadcaster = new Broadcaster();
        Blockchain blockchain = new Blockchain();

        
	@Autowired
	public RestApi() {
	}

	@RequestMapping("/greeting")
	public String echo() {
            System.out.println("greeting");
            return "test";
	}
        
        // TODO: 
        
        // TODO: GET THE RETURN VALUE AND REPLACE THE CHAIN
        // ITS A HACK FOR NOW. BETTER THAN NOTHING.
        @RequestMapping(path = "/getBlockchain", method = RequestMethod.GET)
        @ResponseBody
	public Boolean getBlockChain() {
            blockchain.replaceChain(null);
            return true;
	}

	@RequestMapping(path = "/receive/transaction", method = RequestMethod.POST)
	public Boolean receiveTransaction(@RequestBody Transaction t) throws Exception {
            System.out.println(t.toString());
            blockchain.createNewBlock(t);
            return true;
	}

	@RequestMapping(path = "/broadcast/transaction", method = RequestMethod.POST)
	public Boolean broadcastTransaction(@RequestBody Transaction t) {
            System.out.println(t.toString());
            broadcaster.broadcastTransaction(t, 500);
            System.out.println(t.toString());
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
