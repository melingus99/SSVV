package ubb.ssvv;

import org.junit.Test;
import ubb.ssvv.domain.Tema;
import ubb.ssvv.repository.NotaXMLRepo;
import ubb.ssvv.repository.StudentXMLRepo;
import ubb.ssvv.repository.TemaXMLRepo;
import ubb.ssvv.service.Service;
import ubb.ssvv.validation.NotaValidator;
import ubb.ssvv.validation.StudentValidator;
import ubb.ssvv.validation.TemaValidator;
import ubb.ssvv.validation.ValidationException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AssignmentTest {
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    StudentXMLRepo studentXMLRepository = new StudentXMLRepo("fisiere/StudentiTest.xml");
    TemaXMLRepo temaXMLRepository = new TemaXMLRepo("fisiere/TemeTest.xml");
    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
    NotaXMLRepo notaXMLRepository = new NotaXMLRepo("fisiere/Note.xml");
    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Test
    public void tc_1_addAssignment() {
        if(service.findTema("1") != null)
            service.deleteTema("1");
        Tema assignment = new Tema("1", "desc", 4, 3);
        assertNull(service.addTema(assignment));
}

    @Test(expected = ValidationException.class)
    public void tc_2_addAssignment() {
        Tema assignment = new Tema(null, "desc", 4, 3);
        service.addTema(assignment);
    }

    @Test(expected = ValidationException.class)
    public void tc_3_addAssignment() {
        Tema assignment = new Tema("2", "", 4, 3);
        service.addTema(assignment);
    }

    @Test(expected = ValidationException.class)
    public void tc_4_addAssignment() {
        Tema assignment = new Tema("3", "desc", 15, 3);
        service.addTema(assignment);
    }

    @Test(expected = ValidationException.class)
    public void tc_5_addAssignment() {
        Tema assignment = new Tema("4", "desc", 4, 15);
        service.addTema(assignment);
    }

    @Test
    public void tc_6_addAssignment() {
        if(service.findTema("5") != null)
            service.deleteTema("5");
        service.addTema(new Tema("5", "desc", 4, 3));

        Tema assignment = new Tema("5", "desc", 4, 3);
        assertNotNull(service.addTema(assignment));
    }

}
