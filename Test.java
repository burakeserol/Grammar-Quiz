import java.io.IOException;
import java.net.UnknownHostException;

public class Test {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Controller controller;
		Model model;
		View view;

		controller = new Controller();
		model = new Model(controller);
		view = new View(controller);
		controller.addModel(model);
		controller.addView(view);

	}

}
