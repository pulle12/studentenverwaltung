package at.hakimst.studentenverwaltung.services;

import at.hakimst.studentenverwaltung.domain.Student;
import at.hakimst.studentenverwaltung.exceptions.StudentNichtGefunden;

import java.util.List;

public interface StudentenService {

    List<Student> alleStudenten();
    Student studentEinfuegen(Student student);
    Student studentMitId(Long id) throws StudentNichtGefunden;
    List<Student> alleStudentenMitPlz(String plz);
    void studentLoeaschenMitId(Long id);
}
