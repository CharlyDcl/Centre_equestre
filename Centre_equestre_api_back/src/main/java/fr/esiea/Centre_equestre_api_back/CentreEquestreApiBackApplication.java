package fr.esiea.Centre_equestre_api_back;

import fr.esiea.Centre_equestre_api_back.Model.Cours;
import fr.esiea.Centre_equestre_api_back.Model.User;
import fr.esiea.Centre_equestre_api_back.Repository.CoursRepository;
import fr.esiea.Centre_equestre_api_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CentreEquestreApiBackApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CentreEquestreApiBackApplication.class, args);
		System.out.println("test application");
	}

	@Autowired
	UserRepository userRepo;

	@Autowired
	CoursRepository coursRepo;

	@Override
	public void run(String... args) throws Exception {
		User newuser = new User("nom", "prenom",0, "admin", "USER", "a", "mail", "phone" );
		userRepo.save(newuser);

		Cours newcours = new Cours("debutant", "12/11/2020", "10h00", 3);
		coursRepo.save(newcours);
		System.out.println(userRepo.findAll());
	}
}
