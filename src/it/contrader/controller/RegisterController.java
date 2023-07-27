package it.contrader.controller;

import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.UserService;

import java.sql.SQLException;

public class RegisterController implements Controller{

    private it.contrader.service.UserService UserService;
    private static String sub_package="user.";
    public RegisterController() throws SQLException {
        this.UserService= new UserService();
    }

    public void doControl (Request request) {
        /**
         * Attraverso il Dispatcher va alla pagina di registrazione
         */

        //Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)

        String username;
        String password;
        String usertype;
        username = request.get("username").toString();
        password = request.get("password").toString();
        usertype = request.get("usertype").toString();

        //costruisce l'oggetto user da inserire
        UserDTO usertoinsert = new UserDTO(username, password, usertype);
        //invoca il service
        UserService.insert(usertoinsert);

        //creo singleton

        request = new Request();
        request.put("mode", "mode");
        //Rimanda alla view con la risposta

        MainDispatcher.getInstance().callView(sub_package + "UserInsert", request);

    }

}
