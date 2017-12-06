package registry;

import java.util.ArrayList;
import java.util.List;

public class PeerRegistry {
	
	private static PeerRegistry pr = new PeerRegistry();
	private static List<String> registry = new ArrayList<String>();
	
	private PeerRegistry () {
		registry.add("http://192.168.99.100:8080/greeting");
		registry.add("http://192.168.99.100:8081/greeting");
		registry.add("http://192.168.99.100:8082/greeting");
	}
	
	public static void addPeer(String peerAddress) {
		registry.add(peerAddress);
	}
	
	public static List<String> getRegistry() {
		return registry;
	}
	
}
