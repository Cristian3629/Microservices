package es.kita.model;


import es.kita.model.Career;
import es.kita.model.Course;

import java.util.LinkedList;
import java.util.List;

public class Student {
    private String padron;
    private String name;
    private String email;
    private Career carrera;
    private List<Course> cursos;

    public Student(String padron, String name, String email) {
        super();
        this.padron = padron;
        this.name = name;
        this.email = email;
        this.carrera = new Career();
        this.cursos = new LinkedList<Course>();
    }

    /**
     * @return the padron
     */
    public String getpadron() {
        return padron;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email){
      this.email = email;

    }

    public void setpadron(String padron) {
        this.padron = padron;
    }

    public String getName(){
      return this.name;
    }

    public String getEmail(){
      return this.email;
    }

    public void setCareer(String nombre_carrera,String plan_carrera){
      carrera.setName(nombre_carrera);
      carrera.setPlan(plan_carrera);
    }

    public Boolean inscribirACurso(Course course){
      if (this.getNumberOfCourses() <= 7){
        cursos.add(course);
        return true;
      }
      return false;
    }

    public int getNumberOfCourses(){
      return cursos.size();
    }
}
