package ubb.ssvv;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ubb.ssvv.domain.Student;
import ubb.ssvv.repository.NotaXMLRepo;
import ubb.ssvv.repository.StudentXMLRepo;
import ubb.ssvv.repository.TemaXMLRepo;
import ubb.ssvv.service.Service;
import ubb.ssvv.validation.NotaValidator;
import ubb.ssvv.validation.StudentValidator;
import ubb.ssvv.validation.TemaValidator;
import ubb.ssvv.validation.ValidationException;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.JVM)
public class AppTest 
{
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    StudentXMLRepo studentXMLRepository = new StudentXMLRepo("fisiere/StudentiTest.xml");
    TemaXMLRepo temaXMLRepository = new TemaXMLRepo("fisiere/Teme.xml");
    NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
    NotaXMLRepo notaXMLRepository = new NotaXMLRepo("fisiere/Note.xml");
    Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

    @Test
    public void tc_1_addStudents() {
        Student student = new Student("5", "nume", 933, "da@da");
        service.deleteStudent("5");
        assertNull(service.addStudent(student));
    }

    @Test(expected = ValidationException.class)
    public void tc_2_addStudents() {
        Student student = new Student("11", "nume", 1001, "da@da");
        service.addStudent(student);
    }

    @Test(expected = ValidationException.class)
    public void tc_4_addStudents() {
        Student student = new Student("-5", "nume", 933, "da@da");
        service.addStudent(student);
    }

    @Test(expected = ValidationException.class)
    public void tc_5_addStudents() {
        Student student = new Student("5.5", "nume", 933, "da@da");
        service.addStudent(student);
    }

    @Test(expected = ValidationException.class)
    public void tc_6_addStudents() {
        Student student = new Student("13", "nume123", 933, "da@da");
        service.addStudent(student);
    }

    @Test(expected = ValidationException.class)
    public void tc_7_addStudents() {
        Student student = new Student("14", "nume", 933, "dada");
        service.addStudent(student);
    }

    @Test
    public void tc_8_addStudents() {
        Student student = new Student("5", "nume", 933, "da@da");
        assertNotNull(service.addStudent(student));
    }

    @Test
    public void tc_9_addStudents() {
        Student student = new Student("6", "nume", 933, "da@da");
        service.deleteStudent("6");
        assertNull(service.addStudent(student));
    }

    @Test
    public void tc_10_addStudents() {
        Student student = new Student("0", "name", 100, "da@da");
        service.deleteStudent("0");
        assertNull(service.addStudent(student));
    }

    @Test
    public void tc_11_addStudents() {
        Student student = new Student(String.valueOf(Integer.MAX_VALUE), "name", 933, "da@da");
        service.deleteStudent(String.valueOf(Integer.MAX_VALUE));
        assertNull(service.addStudent(student));
    }

    @Test
    public void tc_12_addStudents() {
        Student student = new Student(String.valueOf(Integer.MAX_VALUE - 1), "name", 933, "da@da");
        service.deleteStudent(String.valueOf(Integer.MAX_VALUE - 1));
        assertNull(service.addStudent(student));
    }

    @Test(expected = ValidationException.class)
    public void tc_14_addStudents() {
        Student student = new Student("66", "name", 0, "da@da");
        service.addStudent(student);
    }

    @Test
    public void tc_15_addStudents() {
        Student student = new Student("77", "name", 1, "da@da");
        service.deleteStudent("77");
        assertNull(service.addStudent(student));
    }

    @Test
    public void tc_16_addStudents() {
        Student student = new Student("88", "name", 999, "da@da");
        service.deleteStudent("88");
        assertNull(service.addStudent(student));
    }

    @Test(expected = ValidationException.class)
    public void tc_17_addStudents() {
        Student student = new Student("99", "name", 1000, "da@da");
        service.addStudent(student);
    }
}
