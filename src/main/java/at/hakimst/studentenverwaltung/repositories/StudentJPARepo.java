package at.hakimst.studentenverwaltung.repositories;

import at.hakimst.studentenverwaltung.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPARepo extends JpaRepository<Student, Long> {
}
