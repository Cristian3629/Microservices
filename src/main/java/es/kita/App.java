package es.kita;


//Controladores
import es.kita.controllers.CourseController;
import es.kita.controllers.StudentController;
import es.kita.controllers.SubjectController;
import es.kita.controllers.CareerController;

//Servicios
import es.kita.services.StudentService;
import es.kita.services.CourseService;
import es.kita.services.SubjectService;
import es.kita.services.CareerService;

public class App {
    public static void main(String[] args) {
        new StudentController(new StudentService());
        new CourseController(new CourseService());
        new SubjectController(new SubjectService());
        new CareerController(new CareerService());
    }
}
