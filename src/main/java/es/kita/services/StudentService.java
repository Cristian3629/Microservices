package es.kita.services;

import java.util.LinkedList;
import java.util.List;

import es.kita.model.Student;

public class StudentService {
    /**
     * Lista de usuarios para pruebas
     */
    private static List<Student> students;

    /**
     * Contador para el id de los nuevos usuarios
     */
    private static int contador = 0;

    /**
     * Contructor sin parámetros
     */
    public StudentService() {
        // Carga de usuarios de pruebas
        students = new LinkedList<Student>();
        contador++;
        students.add(new Student("001", "Periquito", "perico@correo.es"));
        contador++;
        students.add(new Student("007", "James Bond", "james.bond@007.com"));
    }

    /**
     * Recupera la lista completa de usuarios.
     * @return lista de usuarios.
     */
    public List<Student> getAllStudents() {
        //Recupera la lista de usuarios cargada en el constructor
        return students;
    }

    /**
     * Recupera el usuario con el id dado.
     * @param padron identificador del usuario.
     * @return Usuario encontrado o nulo en caso contrario.
     */
    public Student getStudent(String padron) {
      System.out.println("GetStudent");

      Student salida = null;

        for (Student student : students) {
            if (student.getpadron().equals(padron)) {
                salida = student;
                return salida;
            }
        }

        return salida;
    }

    /**
     * Crea un usuario con los datos dados. El id se autocalcula.
     * @param name nombre del usuario.
     * @param email email del usuario.
     * @return Usuario creado.
     */
    public Student createStudent(String name, String email) {
        System.out.println("Student Service create student name:"+name+ " email:"+email);
        contador++;
        Student student = new Student(contador + "", name, email);
        students.add(student);
        return student;
    }

    /**
     * Actualiza los datos de usuario con el id dado.
     * @param id padron del usuario.
     * @param name nombre del usuario.
     * @param email email del usuario.
     * @return Usuario con los datos modificados.
     */
    public Student updateStudent(String padron, String name, String email) {
        Student salida = null;
        System.out.println("updateStudent");
        for (Student student : students) {
            if (student.getpadron().equals(padron)) {
                student.setName(name);
                student.setEmail(email);
                salida = student;
                return salida;
            }
        }

        return salida;
    }

    public Student updateCareerFromStudent(String padron,String nombre_carrera,String plan_carrera){
      Student salida = null;
      System.out.println("updateCareerFromStudent padron:"+padron+"nombre:"+nombre_carrera+"plan:"+plan_carrera);
      for (Student student : students) {
          if (student.getpadron().equals(padron)) {
              student.setCareer(nombre_carrera,plan_carrera);
              salida = student;
              return salida;
          }
      }
      return salida;
    }

}
