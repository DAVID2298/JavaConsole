package it.contrader.controller;

import it.contrader.dto.AppointmentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.service.AppointmentService;

import java.util.List;

public class AppointmentController implements Controller {

    private static String sub_package = "appointment.";

    private AppointmentService appointmentService;

    public AppointmentController(){
        this.appointmentService = new AppointmentService();
    }


    @Override
    public void doControl(Request request) {

        String mode = (String) request.get("mode");

        String choice = (String) request.get("choice");
  //aa
        int id;
        String date;
        String hour;
        double cost;
        int user_id;
        int medicalExaminationId;
        String register;

        switch (mode){

            case "READ":

                id = Integer.parseInt(request.get("id").toString());
                AppointmentDTO appointmentDTO = appointmentService.read(id);
                request.put("appointment", appointmentDTO);
                MainDispatcher.getInstance().callView(sub_package + "AppointmentRead", request);
                break;

            case "INSERT":

                id = Integer.parseInt(request.get("id").toString());
                date = request.get("date").toString();
                hour = request.get("hour").toString();
                cost = Double.parseDouble(request.get("cost").toString());
                user_id = UserSingleton.getInstance().getUserLogged().getId();
                medicalExaminationId = Integer.parseInt(request.get("medicalExaminationId").toString());

                AppointmentDTO appointmentToInsert = new AppointmentDTO(id, date, hour, cost, user_id, medicalExaminationId);

                appointmentService.insert(appointmentToInsert);
                request = new Request();
                request.put("mode", "mode");

                MainDispatcher.getInstance().callView(sub_package+"AppointmentInsert", request);
                break;

            case "APPOINTMENT":
                List<AppointmentDTO> appointmentDTOS = appointmentService.getAll(UserSingleton.getInstance().getUserLogged().getId());

                request.put("appointments", appointmentDTOS);
                MainDispatcher.getInstance().callView("Appointment", request);
                break;

            case "GETCHOICE":

                switch (choice.toUpperCase()){

                    case "L":
                        MainDispatcher.getInstance().callView(sub_package + "AppointmentRead",null);
                        break;

                    case "I":
                        MainDispatcher.getInstance().callView(sub_package+"AppointmentInsert",null);
                        break;

                    case "C":
                        MainDispatcher.getInstance().callView(sub_package+"AppointmentDelete", null);
                        break;
                    case "V":
                        MainDispatcher.getInstance().callView(sub_package+"AppointmentReadAll", null);
                        break;

                    case "B":
                        MainDispatcher.getInstance().callView("HomeAdmin",null);

                    default:
                        MainDispatcher.getInstance().callView("Login",null);
                }

            default:
                MainDispatcher.getInstance().callView("Login", null);

        }

    }
}