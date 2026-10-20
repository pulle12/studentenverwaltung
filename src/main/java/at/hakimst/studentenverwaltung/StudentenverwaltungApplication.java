package at.hakimst.studentenverwaltung;

import at.hakimst.studentenverwaltung.domain.Student;
import at.hakimst.studentenverwaltung.repositories.StudentJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner {

	@Autowired
	StudentJPARepo studentJPARepo;

	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.studentJPARepo.save(new Student("Paul Summerauer", "6460"));
		this.studentJPARepo.save(new Student("Günter Hasel", "3322"));
		this.studentJPARepo.save(new Student("Maria Brunsteiner", "8080"));
	}
}
