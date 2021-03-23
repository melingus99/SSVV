package ubb.ssvv.validation;

import ubb.ssvv.domain.Student;

public class StudentValidator implements Validator<Student> {

    /**
     * Valideaza un student
     * @param entity - studentul pe care il valideaza
     * @throws ValidationException - daca studentul nu e valid
     */
    @Override
    public void validate(Student entity) throws ValidationException {
        if(entity.getID().equals("")){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getID() == null){
            throw new ValidationException("Id incorect!");
        }
        if(!entity.getID().matches("\\d+")) {
            throw new ValidationException("Id incorect!");
        }
        if(Integer.parseInt(entity.getID()) < 0) {
            throw new ValidationException("Id incorect!");
        }
        if(entity.getNume() == ""){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getNume() == null){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getNume().matches(".*\\d+")) {
            throw new ValidationException("Nume incorect!");
        }

        if(entity.getGrupa() < 1) {
            throw new ValidationException("Grupa incorecta!");
        }
        if(entity.getGrupa() > 999){
            throw new ValidationException("Grupa incorecta!");
        }

        if(entity.getEmail() == null){
            throw new ValidationException("Email incorect!");
        }
        if(!entity.getEmail().matches(".*@.*")){
            throw new ValidationException("Email incorect!");
        }
        if(entity.getEmail().equals("")){
            throw new ValidationException("Email incorect!");
        }
    }
}
