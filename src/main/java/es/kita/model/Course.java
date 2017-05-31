package es.kita.model;


public class Course{

  private String id;
  private String idSubject;
  private String teacherName;

  public Course(String id,String idSubject,String teacherName){
    this.id = id;
    this.idSubject = idSubject;
    this.teacherName = teacherName;
  }

  public String getId(){
    return this.id;
  }

  public void setId(String id){
    this.id = id;
  }

  public void setIdSubject(String id){
    this.idSubject = id;
  }

  public String getIdSubject(){
    return idSubject;
  }

  public String getTeacherName(){
    return this.teacherName;
  }

  public void setTeacherName(String name){
    this.teacherName = name;
  }

}
