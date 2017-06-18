package es.kita.services;


import java.util.LinkedList;
import java.util.List;

import es.kita.model.Course;

public class CourseService{

  private static List<Course> courses;
  private static int contador = 0;


  public CourseService(){
    this.courses = new LinkedList<Course>();
    this.courses.add(new Course("001","Tecnicas de Diseño","Carlos Montana","1"));
    this.courses.add(new Course("002","Tecnicas de Diseño","Adriana Martinez","1"));
    this.courses.add(new Course("003","Tecnicas de Diseño","Pedro Fontana","1"));
    this.courses.add(new Course("002","Base de Datos","Claudia Gonzalez","2"));
    this.courses.add(new Course("001","Base de Datos","Romina Gonzalez","2"));
    this.courses.add(new Course("002","Teoria del Lenguaje","Leticia Perez","1"));
    this.courses.add(new Course("003","Teoria del Lenguaje","Celestino Riquelme","1"));
    this.courses.add(new Course("002","Señales","Lucas Prado","1"));
    this.courses.add(new Course("001","Analisis II","Matias Benitez","2"));
    this.courses.add(new Course("002","Analisis II","Matias Gonzalez","2"));
    this.courses.add(new Course("003","Analisis II","Cristian Perez","2"));
    this.courses.add(new Course("004","Analisis II","Pedro Juanes","1"));
    this.courses.add(new Course("001","Fisica III","Juliana Benitez","1"));
    this.courses.add(new Course("002","Fisica I","Matias Medina","2"));
    this.courses.add(new Course("001","Arquitectura de Software","Alejando Ayala","1"));
    this.courses.add(new Course("003","Analisis II","Sebastian Benitez","1"));
    this.courses.add(new Course("006","Tecnicas de Diseño","Maite Angelone","2"));
    this.courses.add(new Course("003","Tecnicas de Diseño","Leopoldo Ramirez","1"));
  }

  public List<Course> getAllCourses(){
    return courses;
  }

  public Course getCourse(String id,String subject_name){
    System.out.println("Quiero obtener curso con id:"+id+"idSubject:"+subject_name);
    Course salida =  null;
    for (Course course: courses ) {
      if(course.getId().equals(id) || course.getSubjectName().equals(subject_name)){
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




  public List<Course> getCoursesBySubjectName(String subject_name){
    List<Course> salida = new LinkedList<Course>();
    for (Course course :courses ) {
      if (course.getSubjectName().equals(subject_name)){
        salida.add(course);
      }
    }
    return salida;
  }

  public Course createCourse(String id, String name,String teacherName){
    return null;
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

  public List<Course> getCoursesByCuatrimestreAndBySubject(String cuatrimestre,String subject_name){
    List<Course> list = new LinkedList<Course>();

    for (Course course : courses ) {
      if(course.getSubjectName().equals(subject_name) && course.getCuatrimestre().equals(cuatrimestre)){
        list.add(course);
      }
    }
    if (list.isEmpty()){
      list.add(new Course("",subject_name,"",""));
    }
    return list;
  }

}
