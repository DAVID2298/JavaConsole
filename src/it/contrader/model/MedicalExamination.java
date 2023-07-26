package it.contrader.model;

import java.util.List;
import java.util.TimeZone;

public class MedicalExamination {

    private long id;

    private String name;

    private String typology;

    private double cost;

    private long code;

    private TimeZone hours;

    private String img;

    private List<Appointment> appointments;
}
