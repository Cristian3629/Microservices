package es.kita.model;


public class Career{

  private String id;
  private String name;


  public Career(String codigo, String name){
    super();
    this.id = id;
    this.name = name;
  }


  public String getId(){
    return this.id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getName(){
    return this.name;
  }


  public void setName(String name){
    this.name = name;
  }

}
