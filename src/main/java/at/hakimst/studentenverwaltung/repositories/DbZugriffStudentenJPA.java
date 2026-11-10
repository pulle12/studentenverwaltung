package at.hakimst.studentenverwaltung.repositories;

import at.hakimst.studentenverwaltung.domain.Student;
import at.hakimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbZugriffStudentenJPA implements DbZugriffStudenten {

    private StudentJPARepo studentJPARepo;

    public DbZugriffStudentenJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }

    @Override
    public Student studentSpeichern(Student student) {
        return this.studentJPARepo.save(student);
    }

    @Override
    public List<Student> alleStudenten() {
        return this.studentJPARepo.findAll();
    }

    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return this.studentJPARepo.findAllByPlz(plz);
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        Optional<Student> optStudent = this.studentJPARepo.findById(id);
        if(optStudent.isPresent()) {
            return optStudent.get();
        } else {
            throw new StudentNichtGefunden("Student mit der Id " + id + " nicht gefunden!");
        }
    }

    @Override
    @Transactional // Sorgt dafür, dass Laden und Löschen in einer sicheren Transaktion stattfinden
    public Student studentLoeschenMitId(Long id) throws StudentNichtGefunden {
        Student studentZumLoeschen = this.studentMitId(id);
        this.studentJPARepo.deleteById(id);
        return studentZumLoeschen;
    }
}
