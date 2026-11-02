package at.hakimst.studentenverwaltung.services;

import at.hakimst.studentenverwaltung.domain.Student;
import at.hakimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.hakimst.studentenverwaltung.repositories.DbZugriffStudenten;

import java.util.List;

public class StudentenServiceImpl implements StudentenService {

    private DbZugriffStudenten dbZugriffStudenten;

    public StudentenServiceImpl(DbZugriffStudenten dbZugriffStudenten) {
        this.dbZugriffStudenten = dbZugriffStudenten;
    }

    @Override
    public List<Student> alleStudenten() {
        return this.dbZugriffStudenten.alleStudenten();
    }

    @Override
    public Student studentEinfuegen(Student student) {
        return this.dbZugriffStudenten.studentSpeichern(student);
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        return this.dbZugriffStudenten.studentMitId(id);
    }

    @Override
    public List<Student> alleStudentenMitPlz(String plz) {
        return this.dbZugriffStudenten.alleStudentenAusDemOrt(plz);
    }

    @Override
    public void studentLoeaschenMitId(Long id) {
        this.dbZugriffStudenten.studentLoeschenMitId(id);
    }
}
