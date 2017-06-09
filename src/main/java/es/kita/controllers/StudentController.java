package es.kita.controllers;

import es.kita.services.StudentService;
import es.kita.utils.JsonTransformer;
import es.kita.model.Student;


import static spark.Spark.get;
import static spark.Spark.after;
import static spark.Spark.post;
import static spark.Spark.put;
import com.google.gson.Gson;


public class StudentController {
    public StudentController(final StudentService studentService) {
        // Método para tratar los gets de /Students
        get("/students", (request, response) -> studentService.getAllStudents(), new JsonTransformer());

        post("/students", (req, res) -> {
        System.out.println("POST STUDENTS");
        // Se cargan los parámetros de la query (URL)
        String name = req.queryParams("nombre");
        String email = req.queryParams("email");
        String body = req.body();
        System.out.println("POST STUDENTS body:"+body);
        System.out.println("POST STUDENTS name:"+name);
        System.out.println("POST STUDENTS email:"+email);

        // Convertimos de JSON a objeto de la clase Student
        Student student = new Gson().fromJson(body, Student.class);
        if (student != null) {
          System.out.println("---- Usuario cargado correctamente.");
          name = student.getName();
          email = student.getEmail();
        }

        System.out.println("---- Datos del usuario.");
        System.out.println("---- name: " + name);
        System.out.println("---- email: " + email);
        res.status(200);
        //res.responseText("Alumno cargado de manera correcta");
        return studentService.createStudent(name, email);
      }, new JsonTransformer());


      //Actualiza los datos
      put("/students/:idUser", (req, res) -> {

        System.out.println("PUT");
        String idUser = req.params(":idUser");

        // Se cargan los parámetros de la query (URL)
        String name = req.queryParams("name");
        String email = req.queryParams("email");
        String career = req.queryParams("carrera");

        Student student = studentService.getStudent(idUser);
        if (student != null) {
          return studentService.updateStudent(idUser, name, email);
        }
        res.status(400);
        return "No user with id '" + idUser + "' found";
      }, new JsonTransformer());


      // delete("/users/:idUser", (req, res) -> {
      //   String idUser = req.params(":idUser");
      //
      //   Student student  = userService.getUser(idUser);
      //   if (student != null) {
      //     userService.deleteUser(idUser);
      //     res.status(200);
      //     return "User with id '" + idUser + "' deleted";
      //   }
      //
      //   res.status(400);
      //   return "No user with id '" + idUser + "' found";
      // }, new JsonTransformer());



      after((request, response) -> {
        response.type("application/json");
      });

    }
}
