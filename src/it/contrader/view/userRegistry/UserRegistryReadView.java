package it.contrader.view.userRegistry;

import it.contrader.controller.Request;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;
import it.contrader.view.AbstractView;

import java.util.List;

public class UserRegistryReadView extends AbstractView {

    private int userId;
    private Request request;
    private final String mode= "READ";

    public UserRegistryReadView(){

    }
    @Override
    public void showResults(Request request) {
        if (request!=null){
            UserRegistryDTO userRegistryDTO=(UserRegistryDTO) request.get("userRegistry");
            System.out.println(userRegistryDTO);
            MainDispatcher.getInstance().callView("UserRegistry",null);
        }
//        @SuppressWarnings("unchecked")
//        List<UserRegistryDTO> userRegistryS = (List<UserRegistryDTO>) request.get("userRegistryS");
//        for(UserRegistryDTO u: userRegistryS){
//            System.out.println(u);
//            System.out.println();
//
//        }
    }

    @Override
    public void showOptions() {
        System.out.println("sono nell'read anagrafico");

    }

    @Override
    public void submit() {
        request = new Request();
        request.put("userId", userId);
        request.put("mode", mode);
        MainDispatcher.getInstance().callAction("UserRegistry", "doControl", request);

    }

}
