package sg.edu.nus.iss.workshop26;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.workshop26.repo.GameRepo;



@SpringBootApplication
public class Workshop26Application implements CommandLineRunner{

	@Autowired
	GameRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(Workshop26Application.class, args);
	}
	@Override
	public void run(String...args){
		System.out.println("HElloooo");
		System.out.println(repo.search(10,0));
	}
}
