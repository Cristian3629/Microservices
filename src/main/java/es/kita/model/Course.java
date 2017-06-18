package es.kita.model;


public class Course{

  private String id;
  private String nameSubject;
  private String teacherName;
  private String cuatrimestre;

  public Course(String id,String nameSubject,String teacherName,String cuatrimestre){
    this.id = id;
    this.nameSubject = nameSubject;
    this.teacherName = teacherName;
    this.cuatrimestre = cuatrimestre;
  }

  public String getId(){
    return this.id;
  }

  public void setId(String id){
    this.id = id;
  }

  public void setSubjectName(String subject_name){
    this.nameSubject = subject_name;
  }

  public String getSubjectName(){
    return nameSubject;
  }

  public String getTeacherName(){
    return this.teacherName;
  }

  public void setTeacherName(String name){
    this.teacherName = name;
  }

  public void setCuatrimestre(String cuatrimestre){
    this.cuatrimestre = cuatrimestre;
  }

  public String getCuatrimestre(){
    return this.cuatrimestre;
  }
}
