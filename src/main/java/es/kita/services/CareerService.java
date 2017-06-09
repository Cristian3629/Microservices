package es.kita.services;

import java.util.LinkedList;
import java.util.List;

import es.kita.model.Career;

public class CareerService {
    private static List<Career> careers;


    public CareerService() {
        // Carga de carreras de pruebas
        careers = new LinkedList<Career>();
        careers.add(new Career("001", "Ingenieria Informática", "2011"));
        careers.add(new Career("002", "Ingenieria Quimica", "2011"));
        careers.add(new Career("003", "Ingenieria Electronica", "1989"));
        careers.add(new Career("004", "Ingenieria Electronica", "2011"));
        careers.add(new Career("005", "Ingenieria Mecánica", "1989"));
        careers.add(new Career("006", "Ingenieria Electricista", "1989"));
        careers.add(new Career("007", "Ingenieria Naval", "1989"));
        careers.add(new Career("008", "Analista de Sistemas", "2016"));
    }


    public List<Career> getAllCareers() {
        //Recupera la lista de usuarios cargada en el constructor
        return careers;
    }

}
