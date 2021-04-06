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

public class GradeTest {
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    StudentXMLRepo studentXMLRepository = new StudentXMLRepo("fisiere/StudentiTest.xml");
    TemaXMLRepo temaXMLRepository = new TemaXMLRepo("fisiere/TemeTest.xml");
    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
    NotaXMLRepo notaXMLRepository = new NotaXMLRepo("fisiere/NoteTest.xml");
    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Test
    public void tc_1_addGrade() {
        service.addStudent(new Student("55", "nume", 933, "email@email.email"));
        service.addTema(new Tema("55", "desc", 9, 7));
        if(service.findNota("1") != null)
            service.deleteNota("1");
        Nota nota = new Nota("1", "55", "55", 8, LocalDate.of(2018, 10, 15));
        assertEquals(8.0, service.addNota(nota, "feedback"), 0.0002);
    }
}
