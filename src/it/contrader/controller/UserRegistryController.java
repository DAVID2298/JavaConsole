package it.contrader.controller;

import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.model.User;
import it.contrader.model.UserRegistry;
import it.contrader.service.UserRegistryService;
import it.contrader.service.UserService;

import java.util.List;

public class UserRegistryController implements Controller{

    private static String sub_package= "userRegistry.";
    private UserRegistryService userRegistryService;
    private UserService userService;
    public UserRegistryController(){
        this.userRegistryService= new UserRegistryService();
        this.userService= new UserService();
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
    long id;
    String register;
    UserRegistryDTO userRegistryDTO;
    User user = new User();
    UserRegistry userRegistry = new UserRegistry();

        switch (mode){

        case "READ":

            userId=UserSingleton.getInstance().getUserLogged().getId();
            System.out.println(userId);
            UserRegistryDTO datiAnagraficiDTO=userRegistryService.read(userId);
            request.put("userRegistry",datiAnagraficiDTO);
            MainDispatcher.getInstance().callView(sub_package + "UserRegistryRead",request);
            break;

        case "INSERT":
            System.out.println("sono qui");
//            GlobalVariables gui = new GlobalVariables();
//            userId= ((Integer) gui.getGlobalIntVariable()).intValue();
//            UserRegistryDTO userR=userRegistryService.read(userId);
            name=request.get("name").toString();
            surname=request.get("surname").toString();
            address=request.get("address").toString();
            dateBirthday=  request.get("dateBirthday").toString();
//            userId= Integer.parseInt((request.get("userId").toString()));
            userId=UserSingleton.getInstance().getUserLogged().getId();
            register=request.get("register").toString();
            UserRegistryDTO u= new UserRegistryDTO(name,surname,address,dateBirthday,userId);
//            userRegistry.getUserId();
//            user.getId();
//            userRegistryDTO.setUserId(user.getId());
            userRegistryService.insert(u);
            request = new Request();
            request.put("register", register);
            MainDispatcher.getInstance().callView(sub_package + "UserRegistryInsert", request);
            break;


        case "UPDATE":
            System.out.println("sono qui");
            int i = UserSingleton.getInstance().getUserLogged().getId();
//            GlobalVariables globalVariables = new GlobalVariables();
//            userId= ((Integer) globalVariables.getGlobalIntVariable()).intValue();
//            UserRegistryDTO userRegistryDTO1=userRegistryService.read(userId);
//            System.out.println(userId);
//            userId=UserSingleton.getInstance().getUserLogged().getId();
            id= userRegistryService.readId(i);
//            id = Integer.parseInt(request.get("id").toString());
            name=request.get("name").toString();
            surname=request.get("surname").toString();
            address=request.get("address").toString();
            dateBirthday= request.get("dateBirthday").toString();
//            userId= Integer.parseInt(request.get("userId").toString());
//            register=request.get("register").toString();
            userId=UserSingleton.getInstance().getUserLogged().getId();
            UserRegistryDTO userRegistryUpdate =new UserRegistryDTO(id,name,surname,address,dateBirthday,userId);
//            userRegistry.setUserId(userId);

            System.out.println(userRegistryUpdate);
//            userRegistryUpdate.setUserId(userId);
            userRegistryService.update(userRegistryUpdate);
            request = new Request();
            request.put("mode",userRegistryUpdate );
            System.out.println(userRegistryUpdate+" aaaa");
            MainDispatcher.getInstance().callView(sub_package + "Prova", request);
            System.out.println(userRegistryUpdate);

            break;
//        case "UPDATE":
//            System.out.println("sono qui");
//            GlobalVariables globalVariables = new GlobalVariables();
//            userId= ((Integer) globalVariables.getGlobalIntVariable()).intValue();
//            UserRegistryDTO userRegistryDTO1=userRegistryService.read(userId);
////            userRegistryDTO = (UserRegistryDTO) request.get("userRegistry");
//            boolean updateUserRegistry = userRegistryService.update(userRegistryDTO1);
//
//            request.put("mode","UPDATE");
//            MainDispatcher.getInstance().callView(  sub_package + "Prova", request);
//            System.out.println();
//            break;

            case "DELETE":
                System.out.println("ajajajaj");
                id =UserSingleton.getInstance().getUserLogged().getId();
                //Qui chiama il service
                userService.delete((int) id);
                System.out.println("ajajajaj");

                request = new Request();
                request.put("mode", "mode");
                MainDispatcher.getInstance().callView("userRegistry." + "UserRegistryDelete", request);
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
//                    userId=UserSingleton.getInstance().getUserLogged().getId();
//                    System.out.println(UserSingleton.getInstance().getUserLogged());
                    MainDispatcher.getInstance().callView(sub_package + "UserRegistryRead", null);
                    break;

                case "I":
                    MainDispatcher.getInstance().callView(sub_package + "UserRegistryInsert", null);
                    break;

                case "M":

                    MainDispatcher.getInstance().callView(sub_package + "Prova", null);
                    break;

                case "E":
                    MainDispatcher.getInstance().callView("Login", null);
                    break;
//
                case "B":
                    MainDispatcher.getInstance().callView("HomeUser", null);
                    break;
                case "P":
                    MainDispatcher.getInstance().callView("Appointment", null);
                    break;
                case "C":
                    MainDispatcher.getInstance().callView("userRegistry." + "UserRegistryDelete", null);
                    break;
                case "D":
                    MainDispatcher.getInstance().callView("medicalE."+"MedicalEF", null);
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
