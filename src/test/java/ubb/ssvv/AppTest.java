package ubb.ssvv;

import org.junit.Test;
import ubb.ssvv.domain.Student;
import ubb.ssvv.repository.NotaXMLRepo;
import ubb.ssvv.repository.StudentXMLRepo;
import ubb.ssvv.repository.TemaXMLRepo;
import ubb.ssvv.service.Service;
import ubb.ssvv.validation.NotaValidator;
import ubb.ssvv.validation.StudentValidator;
import ubb.ssvv.validation.TemaValidator;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    StudentXMLRepo studentXMLRepository;
    TemaXMLRepo temaXMLRepository;
    NotaValidator notaValidator;
    NotaXMLRepo notaXMLRepository;
    Service service;

    @Test
    void tc_1_addStudents() {
        studentXMLRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        temaXMLRepository = new TemaXMLRepo("fisiere/Teme.xml");
        notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        notaXMLRepository = new NotaXMLRepo("fisiere/Note.xml");
        service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student student = new Student("1", "test1", 933, "email1");
        assertNull(service.addStudent(student));
    }

    @Test
    void tc_2_addStudents() {
        studentXMLRepository = new StudentXMLRepo("fisiere/Studenti.xml");
        temaXMLRepository = new TemaXMLRepo("fisiere/Teme.xml");
        notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        notaXMLRepository = new NotaXMLRepo("fisiere/Note.xml");
        service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student student = new Student("2", "test2", 1001, "email2");
        assertNotNull(service.addStudent(student));
    }
}
