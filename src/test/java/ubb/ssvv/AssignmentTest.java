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

public class AssignmentTest {
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    StudentXMLRepo studentXMLRepository = new StudentXMLRepo("fisiere/StudentiTest.xml");
    TemaXMLRepo temaXMLRepository = new TemaXMLRepo("fisiere/TemeTest.xml");
    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
    NotaXMLRepo notaXMLRepository = new NotaXMLRepo("fisiere/Note.xml");
    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Test(expected = ValidationException.class)
    public void tc_1_addAssignment() {
        Tema assignment = new Tema("", "desc1", 1, 3);
        service.addTema(assignment);
}

    @Test(expected = ValidationException.class)
    public void tc_2_addAssignment() {
        Tema assignment = new Tema("1", "", 1, 3);
        service.addTema(assignment);
    }

}
