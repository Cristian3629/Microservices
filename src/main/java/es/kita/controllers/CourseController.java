package es.kita.controllers;


import es.kita.services.CourseService;
import es.kita.utils.JsonTransformer;
import es.kita.model.Course;


import static spark.Spark.get;
import static spark.Spark.after;
import static spark.Spark.post;
import static spark.Spark.put;
import com.google.gson.Gson;


public class CourseController {
    public CourseController(final CourseService courseService) {
        // Método para tratar los gets de /Courses
        get("/courses", (request, response) -> courseService.getAllCourses(), new JsonTransformer());

        get("/courses/id/:id", (request, response) -> {
          String id = request.params(":id");
          return courseService.getCourseById(id);
        }, new JsonTransformer());

        get("/courses/idAsignature/:id",(request, response) -> {
          String id = request.params(":id");
          return courseService.getCoursesByIdSubject(id);
        }, new JsonTransformer());

        get("/courses/course/:id-:idAsignature",(request, response) -> {
          System.out.println("request:"+request);
          System.out.println("Get course");
          String id = request.params(":id");
          String idAsignature = request.params(":idAsignature");
          return courseService.getCourse(id,idAsignature);
        }, new JsonTransformer());

      //   post("/courses", (req, res) -> {
      //   // Se cargan los parámetros de la query (URL)
      //   String name = req.queryParams("name");
      //   String email = req.queryParams("email");
      //   String body = req.body();
      //   // Convertimos de JSON a objeto de la clase Course
      //   Course course = new Gson().fromJson(body, Course.class);
      //   if (course != null) {
      //     System.out.println("---- Usuario cargado correctamente.");
      //     name = course.getName();
      //     email = course.getEmail();
      //   }
      //
      //   System.out.println("---- Datos del usuario.");
      //   System.out.println("---- name: " + name);
      //   System.out.println("---- email: " + email);
      //   return courseService.createCourse(name, email);
      // }, new JsonTransformer());
      //
      //
      // //Actualiza los datos
      // put("/courses/:idUser", (req, res) -> {
      //
      //   System.out.println("PUT");
      //   String idUser = req.params(":idUser");
      //
      //   // Se cargan los parámetros de la query (URL)
      //   String name = req.queryParams("name");
      //   String email = req.queryParams("email");
      //
      //   Course course = courseService.getCourse(idUser);
      //   if (course != null) {
      //     return courseService.updateCourse(idUser, name, email);
      //   }
      //   res.status(400);
      //   return "No user with id '" + idUser + "' found";
      // }, new JsonTransformer());
      //
      //
      // delete("/users/:idUser", (req, res) -> {
      //   String idUser = req.params(":idUser");
      //
      //   Course course  = userService.getUser(idUser);
      //   if (course != null) {
      //     userService.deleteUser(idUser);
      //     res.status(200);
      //     return "User with id '" + idUser + "' deleted";
      //   }
      //
      //   res.status(400);
      //   return "No user with id '" + idUser + "' found";
      // }, new JsonTransformer());
      //


      after((request, response) -> {
        response.type("application/json");
      });

    }
}
