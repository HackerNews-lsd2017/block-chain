package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import util.MinerThread;


@SpringBootApplication
public class StartPeer {

	public static void main(String[] args) {
		
		SpringApplication.run(StartPeer.class, args);
		new Thread(new MinerThread()).start();
		System.out.println();
		System.out.println("----------------Application is ready------------------");
		System.out.println();

	}

}
