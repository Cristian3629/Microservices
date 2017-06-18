package es.kita.model;


import es.kita.model.Career;

public class Student {
    private String padron;
    private String name;
    private String email;
    private Career carrera;

    public Student(String padron, String name, String email) {
        super();
        this.padron = padron;
        this.name = name;
        this.email = email;
        this.carrera = new Career();
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
}
