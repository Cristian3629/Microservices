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

        after((request, response) -> {
        response.type("application/json");
      });

    }
}
