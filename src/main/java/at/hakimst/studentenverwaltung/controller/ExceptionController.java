package at.hakimst.studentenverwaltung.controller;

import at.hakimst.studentenverwaltung.exceptions.ExceptionDTO;
import at.hakimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(StudentNichtGefunden.class)
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentNichtGefunden studentNichtGefunden) {
        return new ResponseEntity<>(new ExceptionDTO("1000", studentNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }
}
