package ubb.ssvv;

import org.junit.Test;
import ubb.ssvv.domain.Nota;
import ubb.ssvv.domain.Student;
import ubb.ssvv.domain.Tema;
import ubb.ssvv.repository.NotaXMLRepo;
import ubb.ssvv.repository.StudentXMLRepo;
import ubb.ssvv.repository.TemaXMLRepo;
import ubb.ssvv.service.Service;
import ubb.ssvv.validation.NotaValidator;
import ubb.ssvv.validation.StudentValidator;
import ubb.ssvv.validation.TemaValidator;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IntegrationTest {
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    StudentXMLRepo studentXMLRepository = new StudentXMLRepo("fisiere/StudentiTest.xml");
    TemaXMLRepo temaXMLRepository = new TemaXMLRepo("fisiere/TemeTest.xml");
    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
    NotaXMLRepo notaXMLRepository = new NotaXMLRepo("fisiere/NoteTest.xml");
    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Test
    public void tc_1_addStudent() {
        if(service.findStudent("111") != null) {
            service.deleteStudent("111");
        }
        Student student = new Student("111", "nume", 933, "da@da");
        assertNull(service.addStudent(student));
    }
    @Test
    public void tc_1_addAssignment() {
        if(service.findTema("111") != null)
            service.deleteTema("111");
        Tema assignment = new Tema("111", "desc", 4, 3);
        assertNull(service.addTema(assignment));
    }

    @Test
    public void tc_1_addGrade() {
        service.addStudent(new Student("111", "nume", 933, "email@email.email"));
        service.addTema(new Tema("111", "desc", 9, 7));
        if(service.findNota("111") != null)
            service.deleteNota("111");
        Nota nota = new Nota("111", "111", "111", 8, LocalDate.of(2018, 10, 15));
        assertEquals(8.0, service.addNota(nota, "feedback"), 0.0002);
    }

    @Test
    public void tc_1_addStudentAssignmentGrade() {
        if(service.findStudent("222") != null) {
            service.deleteStudent("222");
        }
        Student s = service.addStudent(new Student("222", "nume", 933, "email@email.email"));

        if(service.findTema("222") != null) {
            service.deleteTema("222");
        }
        Tema t = service.addTema(new Tema("222", "desc", 9, 7));

        if(service.findNota("222") != null) {
            service.deleteNota("222");
        }
        double n = service.addNota(new Nota("222", "222", "222", 9, LocalDate.of(2018, 10, 15)), "feedback");
        assertNull(s);
        assertNull(t);
        assertEquals(n, 9.0, 0.0002);
    }

    @Test
    public void tc_1_addStudentAssignment() {
        if(service.findStudent("55") != null) {
            service.deleteStudent("55");
        }
        Student s = service.addStudent(new Student("55", "nume", 933, "email@email.email"));

        if(service.findTema("56") != null) {
            service.deleteTema("56");
        }
        Tema t = service.addTema(new Tema("56", "desc", 9, 7));

        assertNull(s);
        assertNull(t);
    }
}
