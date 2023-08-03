package it.contrader.view.user;

import it.contrader.controller.Request;

import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class UserReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public UserReadView() {
	}

	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			UserDTO user = (UserDTO) request.get("user");
			UserRegistryDTO userRegistry=(UserRegistryDTO) request.get("userRegistry");
			System.out.println(user);
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {



	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("userId",id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
