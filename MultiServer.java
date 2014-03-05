import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
	private static ObjectOutputStream multipleChoiceFileOut;
	private static ObjectOutputStream fillBlankFileOut;
	private static ObjectInputStream getMultipleChooiceQuestions;
	private static ServerSocket server;
	private static ObjectInputStream getFillBlankQuestions;
	private static final String password = "0000";

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		// while(true){
		boolean controller = true;
		ArrayList<IQuestion> MultipleChooiceQuestions = new ArrayList<IQuestion>();
		ArrayList<IQuestion> FillBlankQuestions = new ArrayList<IQuestion>();

		File fileMultipleChooice = new File(
				"C:/Users/Mert/Desktop/Server/MultipleChooice.que");
		File fileFillBlank = new File(
				"C:/Users/Mert/Desktop/Server/FillBlank.que");

		server = new ServerSocket(9090);

		getMultipleChooiceQuestions = new ObjectInputStream(
				new FileInputStream(fileMultipleChooice));
		getFillBlankQuestions = new ObjectInputStream(new FileInputStream(
				fileFillBlank));

		MultipleChooiceQuestions = (ArrayList<IQuestion>) getMultipleChooiceQuestions
				.readObject();
		FillBlankQuestions = (ArrayList<IQuestion>) getFillBlankQuestions
				.readObject();

		getFillBlankQuestions.close();
		getMultipleChooiceQuestions.close();

		// multipleChoiceFileOut.writeObject(new ArrayList<IQuestion>());
		// fillBlankFileOut.writeObject(new ArrayList<IQuestion>());

		while (controller) {
			Socket s = server.accept();
			System.out.println("enter");
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());

			String command = (String) in.readObject();

			if (command.equals("TakeFillBlankQuestion")) {
				out.writeObject(FillBlankQuestions);
			} else if (command.equals("TakeMultipleChooiceQuestion")) {
				out.writeObject(MultipleChooiceQuestions);
			} else if (command.equals("AddMultipleChooiceQuestion")) {
				MultipleChooiceQuestions.add((IQuestion) in.readObject());
				System.out.println("ADD");
			} else if (command.equals("AddFillBlankQuestion")) {
				FillBlankQuestions.add((IQuestion) in.readObject());
				System.out.println("ADDF");
			} else if (command.equals("CloseServer")) {
				controller = false;
				System.out.println("Close");
			} else if (command.equals("PasswordControl")) {
				boolean b = false;
				if (password.equals(in.readObject())) {
					b = true;
				}

				out.writeObject(b);
			}else if (command.equals("DeleteFillBlankQuestion")) {
				int i = (int) in.readObject();
				FillBlankQuestions.remove(i);
			}else if (command.equals("DeleteMultipleChoiceQuestion")) {
				int i = (int) in.readObject();
				MultipleChooiceQuestions.remove(i);
			}
			
			FileOutputStream multipleChoiceFile = new FileOutputStream(
					fileMultipleChooice);
			FileOutputStream fillBlankFile = new FileOutputStream(fileFillBlank);

			multipleChoiceFileOut = new ObjectOutputStream(multipleChoiceFile);
			fillBlankFileOut = new ObjectOutputStream(fillBlankFile);

			multipleChoiceFileOut.writeObject(MultipleChooiceQuestions);
			fillBlankFileOut.writeObject(FillBlankQuestions);

			multipleChoiceFileOut.close();
			fillBlankFileOut.close();
			
			
			in.close();
			out.close();
		}
		

		System.out.println("Bitti");

		// }
	}


}
