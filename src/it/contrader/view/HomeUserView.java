package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;

public class HomeUserView extends AbstractView{

	String choice;

	private Request request;

	@Override
	public void showResults(Request request) {
		System.out.println("\n-----Benvenuto.-----");

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");


		System.out.println(" Seleziona cosa vuoi gestire:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [P]renotazioni [D]Filtra visite per tipologia [C]ancella [B]ack [E]sci");
		choice = this.getInput();

	}

	@Override
	public void submit() {

		request= new Request();
		request.put("choice",choice);
		request.put("mode","GETCHOICE");
		MainDispatcher.getInstance().callAction("UserRegistry","doControl",request);
	}

}
