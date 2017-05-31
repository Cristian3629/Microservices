package es.kita;

import es.kita.controllers.CourseController;
import es.kita.controllers.StudentController;
import es.kita.controllers.SubjectController;
import es.kita.services.StudentService;
import es.kita.services.CourseService;
import es.kita.services.SubjectService;

public class App {
    public static void main(String[] args) {
        new StudentController(new StudentService());
        new CourseController(new CourseService());
        new SubjectController(new SubjectService());
    }
}
