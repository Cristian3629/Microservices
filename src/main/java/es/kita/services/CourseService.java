package es.kita.services;



import java.util.LinkedList;
import java.util.List;

import es.kita.model.Course;

public class CourseService{

  private static List<Course> courses;
  private static int contador = 0;


  public CourseService(){
    this.courses = new LinkedList<Course>();
    this.courses.add(new Course("001","001","Carlos Montana"));
    this.courses.add(new Course("001","002","Adriana Martinez"));
    this.courses.add(new Course("001","003","Pedro Fontana"));
    this.courses.add(new Course("002","003","Claudia Gonzalez"));
    this.courses.add(new Course("001","004","Romina Gonzalez"));
    this.courses.add(new Course("002","004","Leticia Perez"));
    this.courses.add(new Course("003","004","Celestino Riquelme"));
    this.courses.add(new Course("002","001","Lucas Prado"));
    this.courses.add(new Course("002","002","Matias Benitez"));
  }

  public List<Course> getAllCourses(){
    return courses;
  }

  public Course getCourse(String id,String idSubject){
    System.out.println("Quiero obtener curso con id:"+id+"idSubject:"+idSubject);
    Course salida =  null;
    for (Course course: courses ) {
      if(course.getId().equals(id) || course.getIdSubject().equals(idSubject)){
        salida = course;
        return salida;
      }
    }
    return salida;
  }

  public List<Course> getCourseById(String id){
    List<Course> salida = new LinkedList<Course>();
    for (Course course: courses) {
      if(course.getId().equals(id)){
        salida.add(course);
      }
    }
    return salida;
  }




  public List<Course> getCoursesByIdSubject(String idSubject){
    List<Course> salida = new LinkedList<Course>();
    for (Course course :courses ) {
      if (course.getIdSubject().equals(idSubject)){
        salida.add(course);
      }
    }
    return salida;
  }

  public Course createCourse(String id, String name,String teacherName){
    Course course = new Course(id,name,teacherName);
    courses.add(course);
    return course;
  }


  public Course updateCourse(String id, String name){
    Course salida = null;
    for (Course course : courses) {
      if (course.getId().equals(id)){
        course.setId(name);
        return course;
      }
    }
    return salida;
  }

}
