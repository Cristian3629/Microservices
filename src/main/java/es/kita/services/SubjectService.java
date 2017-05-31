package es.kita.services;

import java.util.LinkedList;
import java.util.List;

import es.kita.model.Subject;

public class SubjectService {

    private static List<Subject> subjects;

    private static int contador = 0;


    public SubjectService() {
        // Carga de usuarios de pruebas
        subjects = new LinkedList<Subject>();
        subjects.add(new Subject("001", "Tecnicas de Diseño"));
        subjects.add(new Subject("002", "Organizacion de Computadoras"));
        subjects.add(new Subject("003", "Base de Datos"));
        subjects.add(new Subject("004", "Analisis de la Informacion"));
        subjects.add(new Subject("005", "Arquitectura de Software"));
        subjects.add(new Subject("006", "Teoria del Lenguaje"));
        subjects.add(new Subject("007", "Señales"));
        subjects.add(new Subject("008", "Analisis I"));
        subjects.add(new Subject("009", "Analisis II"));
        subjects.add(new Subject("010", "Analisis III"));
        subjects.add(new Subject("010", "Analisis III"));
        subjects.add(new Subject("011", "Fisica III"));
        subjects.add(new Subject("012", "Fisica II"));
        subjects.add(new Subject("013", "Fisica I"));
    }


    public List<Subject> getAllSubjects() {
        //Recupera la lista de usuarios cargada en el constructor
        return subjects;
    }

    public Subject getSubjectById(String id) {
      Subject salida = null;

        for (Subject subject : subjects) {
            if (subject.getId().equals(id)) {
                salida = subject;
                return salida;
            }
        }

        return salida;
    }

    public Subject getSubjectByName(String name) {
      Subject salida = null;

        for (Subject subject : subjects) {
            if (subject.getName().equals(name)) {
                salida = subject;
                return salida;
            }
        }
        return salida;
    }

    public Subject createSubject(String id, String name) {
        contador++;
        Subject subject = new Subject(id, name);
        subjects.add(subject);
        return subject;
    }


    public Subject updateSubject(String id, String name) {
        Subject salida = null;

        for (Subject subject : subjects) {
            if (subject.getId().equals(id)) {
                subject.setName(name);
                salida = subject;
                return salida;
            }
        }

        return salida;
    }

}
