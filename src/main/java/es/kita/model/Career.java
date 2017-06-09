package es.kita.model;


public class Career{

  private String codigo;
  private String name;
  private String plan;


  public Career(String codigo, String name,String plan){
    super();
    this.codigo = codigo;
    this.name = name;
    this.plan = plan;
  }


  public String getcodigo(){
    return this.codigo;
  }

  public void setcodigo(String codigo){
    this.codigo = codigo;
  }

  public String getName(){
    return this.name;
  }


  public void setName(String name){
    this.name = name;
  }

  public String getPlan(){
    return  this.plan;
  }

  public void setPlan(String plan){
    this.plan = plan;
  }

}
