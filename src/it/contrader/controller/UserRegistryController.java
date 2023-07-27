package it.contrader.controller;

import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.model.UserRegistry;
import it.contrader.service.UserRegistryService;

import java.util.List;

public class UserRegistryController implements Controller{

    private static String sub_package= "userRegistry.";
    private UserRegistryService userRegistryService;
    public UserRegistryController(){
        this.userRegistryService= new UserRegistryService();
    }

    @Override
    public void doControl(Request request) {
    String mode =(String) request.get("mode");

    String choice = (String) request.get("choice");

    String name;
    String surname;
    String address;
    String dateBirthday;
    int userId ;
    String register;
    User user = new User();
    UserRegistry userRegistry = new UserRegistry();

        switch (mode){

        case "READ":
            userId= (int) request.get("userId");
            UserRegistryDTO datiAnagraficiDTO=userRegistryService.read(userId);
            request.put("userRegistry",datiAnagraficiDTO);
            MainDispatcher.getInstance().callView(sub_package + "UserRegistryReadView", request);
            break;
        case "INSERT":
            name=request.get("name").toString();
            surname=request.get("surname").toString();
            address=request.get("address").toString();
            dateBirthday=  request.get("dateBirthday").toString();
            userId= Integer.parseInt(request.get("userId").toString());
            register=request.get("register").toString();
            UserRegistryDTO userRegistryDTO = new UserRegistryDTO(name,surname,address,dateBirthday);
            userRegistry.getUserId();
            user.getId();
            userRegistryDTO.setUserId(user.getId());
            userRegistryService.insert(userRegistryDTO);
            request = new Request();
            request.put("register", register);
            MainDispatcher.getInstance().callView(sub_package + "UserRegistryView", request);
            break;
        case "UPDATE":
            name=request.get("name").toString();
            surname=request.get("cognome").toString();
            address=request.get("address").toString();
            dateBirthday= request.get("dateBirthday").toString();


            userId= Integer.parseInt(request.get("userId").toString());
            //register=request.get("register").toString();
            userRegistry.setUserId(user.getId());


            UserRegistryDTO userRegistryUpdate =new UserRegistryDTO(name,surname,address,dateBirthday);
            userRegistryUpdate.setUserId(userId);
            userRegistryService.update(userRegistryUpdate);
            request = new Request();
            request.put("mode", "mode");
            MainDispatcher.getInstance().callView(sub_package + "UserRegistryUpdate", request);
            break;
        case "PROFILO":
            List<UserRegistryDTO> userRegistryDTOList = userRegistryService.getAll();
            //Impacchetta la request con la lista degli user
            request.put("userRegistryS", userRegistryDTOList);
            MainDispatcher.getInstance().callView("UserRegistry", request);
            break;
        case "GETCHOICE":

            //toUpperCase() mette in maiuscolo la scelta
            switch (choice.toUpperCase()) {

                case "L":
                    MainDispatcher.getInstance().callView(sub_package + "UserRegistyRead", null);
                    break;

                case "I":
                    MainDispatcher.getInstance().callView(sub_package + "UserRegistryInsert", null);
                    break;

                case "M":
                    MainDispatcher.getInstance().callView(sub_package + "UserRegistryUpdate", null);
                    break;

                case "E":
                    MainDispatcher.getInstance().callView("Login", null);
                    break;

                case "B":
                    MainDispatcher.getInstance().callView("HomeAdmin", null);
                    break;

                default:
                    MainDispatcher.getInstance().callView("Login", null);
            }
            break;

        default:
            MainDispatcher.getInstance().callView("Login", null);
    }

}


}
