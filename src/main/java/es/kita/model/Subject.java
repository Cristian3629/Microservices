package es.kita.model;


import java.util.LinkedList;
import java.util.List;

public class Subject{

  private String id;
  private String name;

  public Subject(String id, String name){
    this.id = id;
    this.name = name;
  }

  public String getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public void setId(String id){
    this.id = id;
  }

  public void setName(String name){
    this.name = name;
  }

}
