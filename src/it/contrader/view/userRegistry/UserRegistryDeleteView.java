package it.contrader.view.userRegistry;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class UserRegistryDeleteView extends AbstractView {

    private Request request;
    private int id;

    private final String mode="DELETE";

    @Override
    public void showResults(Request request) {
        if(request!=null){
            System.out.println("cancellazione andata a buon fine");
            MainDispatcher.getInstance().callView("UserRegistry",null);
        }
    }

    @Override
    public void showOptions() {
        System.out.println("ciao");
    }

    @Override
    public void submit() {
        request=new Request();
        request.put("mode",mode);
        MainDispatcher.getInstance().callAction("UserRegistry","doControl",request);
    }
}
