package es.kita.controllers;

import es.kita.services.StudentService;
import es.kita.utils.JsonTransformer;
import es.kita.model.Student;
import es.kita.model.Course;


import static spark.Spark.get;
import static spark.Spark.after;
import static spark.Spark.post;
import static spark.Spark.put;
import com.google.gson.Gson;


import org.json.*;


import es.kita.utils.Request;



public class StudentController {

    public StudentController(final StudentService studentService) {
        // Método para tratar los gets de /Students
        get("/students", (request, response) -> studentService.getAllStudents(), new JsonTransformer());


        get("/students/:padron", (request, response) -> {
            String padron = request.params(":padron");
            System.out.println("students Controller get padron:"+padron);
            return "Algo";
        }, new JsonTransformer());


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
        put("/students/career/:padron", (req, res) -> {

        System.out.println("Inscribiendo a alumno a carrera");
        String idUser = req.params(":padron");

        // Se cargan los parámetros de la query (URL)
        String career = req.queryParams("carrera").replaceAll(" ", "%20");
        String plan = req.queryParams("plan");

        //System.out.println("Este es el parseo career:"+career+"plan:"+plan);
        //aca verifico que los datos sean validos
        String url = "http://localhost:4567/careers/"+career+"?plan="+plan;
        Request request = new Request(url,"GET");
        System.out.println("Respuesta del request:"+request.isOk());
        if (request.isOk()){
          return studentService.updateCareerFromStudent(idUser,career,plan);
        }
        //return studentService.updateStudent(idUser, name, email);
        res.status(400);
        return "El usuario "+idUser+" no fue encontrado o los datos de la carrera son incorrectos";
      }, new JsonTransformer());


      put("students/course/:id" , (req,res)->{
        System.out.println("Inscribiendo a alumno a curso");

        String id_student = req.params(":id");
        String asignature_name = req.queryParams("materia").replaceAll(" ", "%20");
        String id_course = req.queryParams("curso");
        String cuatrimestre = req.queryParams("cuatrimestre");

        String url = "http://localhost:4567/courses/"+id_course+"?materia="+asignature_name+"&cuatrimestre="+cuatrimestre;

        Request request = new Request(url,"GET");
        if(request.isOk()){
          //DE esta respuesta, creo un nuevo objecto
          JSONArray jsonResponse = request.getResponse();
          JSONObject jsonObject = jsonResponse.getJSONObject(0);
          String id = jsonObject.getString("id");
          String nameSubject = jsonObject.getString("nameSubject");
          String teacherName = jsonObject.getString("teacherName");
          Course course =  new Course(id,nameSubject,teacherName,cuatrimestre);

          Student student = studentService.addCourseToStudent(id_student,course);
          if (student != null){
            return student;
          }else{
            return "El alumno no existe o ya está inscripto en más de 7 cursos";
          }
        }
        return "{El curso con id:"+id_course+" de la materia :"+asignature_name+"no existe";
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
