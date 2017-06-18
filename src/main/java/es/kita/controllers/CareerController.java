package es.kita.controllers;

import es.kita.services.CareerService;
import es.kita.utils.JsonTransformer;
import es.kita.model.Career;


import static spark.Spark.get;
import static spark.Spark.after;

import com.google.gson.Gson;



public class CareerController {
    public CareerController(final CareerService careerService) {
        // Método para tratar los gets de /Careers
        get("/careers", (request, response) -> careerService.getAllCareers(), new JsonTransformer());

        //http://localhost:4567/careers/name/Ingenieria Electricista
        get("/careers/:name", (request, response) ->{
            System.out.println("Get career name from plan");
            String name = request.params(":name");
            String plan = request.queryParams("plan");

            System.out.println("Name:"+name);
            System.out.println("Plan:"+plan);

            System.out.println("Carrer Controller get name:"+name+"plan:"+plan);
            Career career =  careerService.getCareerFromNameAndPlan(name,plan);
            if (career != null){
              System.out.println("Todo bien, devolvi 200");
              response.status(200);
              return career;
            }
            response.status(400);
            return null;
        }, new JsonTransformer());

        after((request, response) -> {
        response.type("application/json");
      });

    }
}
