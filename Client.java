import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client {
	private Socket s;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private String command;

	public Client() throws UnknownHostException, IOException {
		command = "";
	}

	public ArrayList<IQuestion> getMultipleChooiceQuestions()
			throws IOException, ClassNotFoundException {
		openSocket();
		command = "TakeMultipleChooiceQuestion";
		out.writeObject(command);
		ArrayList<IQuestion> q = (ArrayList<IQuestion>) in.readObject();
		closeSocket();
		return (q);

	}

	public ArrayList<IQuestion> getFillBlankQuestions() throws IOException,
			ClassNotFoundException {
		openSocket();
		command = "TakeFillBlankQuestion";
		out.writeObject(command);
		ArrayList<IQuestion> q = (ArrayList<IQuestion>) in.readObject();
		closeSocket();
		return q;
	}

	public ArrayList<DragDropMemory> getDragDropQuestinos() throws IOException, ClassNotFoundException {

		openSocket();
		command = "TakeDragDropQuestion";
		out.writeObject(command);
		ArrayList<DragDropMemory> q = (ArrayList<DragDropMemory>) in.readObject();
		closeSocket();
		return q;
	}

	public void addMultipleChooiceQuestion(IQuestion q) throws IOException {
		openSocket();
		command = "AddMultipleChooiceQuestion";
		out.writeObject(command);
		out.writeObject(q);
		closeSocket();
	}

	public void addFillBlankQuestion(IQuestion q) throws IOException {
		openSocket();
		command = "AddFillBlankQuestion";
		out.writeObject(command);
		out.writeObject(q);
		closeSocket();
	}

	public void addDragDropQuestion(DragDropMemory emptyDragAndDropQuestion) throws IOException{
		openSocket();
		command = "AddDragDropQuestion";
		out.writeObject(command);
		out.writeObject(emptyDragAndDropQuestion);
		closeSocket();
	}


	public void deleteFillBlankQuestion(int numberOfDeletedQuestion)
			throws UnknownHostException, IOException {
		openSocket();
		command = "DeleteFillBlankQuestion";
		out.writeObject(command);
		out.writeObject(numberOfDeletedQuestion);
		closeSocket();

	}

	public void deleteMultipleChoiceQuestions(int numberOfDeletedQuestion) throws IOException {
		openSocket();
		command = "DeleteMultipleChoiceQuestion";
		out.writeObject(command);
		out.writeObject(numberOfDeletedQuestion);
		closeSocket();

	}

	public void deleteDragDropQuestions(int numberOfDeletedQuestion) throws IOException {
		openSocket();
		command = "DeleteDragDropQuestion";
		out.writeObject(command);
		out.writeObject(numberOfDeletedQuestion);
		closeSocket();

	}

	public boolean passwordControl(String password) throws IOException,
			ClassNotFoundException {
		openSocket();
		command = "PasswordControl";
		out.writeObject(command);
		out.writeObject(password);
		boolean b = (Boolean) in.readObject();
		closeSocket();
		return b;
	}

	public void openSocket() {
		try {
			s = new Socket("cs102project.no-ip.biz", 9090);
			//s = new Socket("127.0.0.1", 9090);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame("Error"), "You cannot connect with server!");
			System.exit(0);
		}
		try {
			in = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeSocket() throws IOException {
		s.close();
		in.close();
		out.close();
	}

	public void closeServer() throws IOException {
		openSocket();
		command = "CloseServer";
		out.writeObject(command);
		closeSocket();

	}

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Client c = new Client();

		GrammarComboBoxQuestion a = new GrammarComboBoxQuestion(
				"Present Tenses", "is", "are", "am", "What - your name?",
				"Beginner");
		GrammarFillBlankQuestion b = new GrammarFillBlankQuestion(
				"Present Tenses", "are", "How old - you?", "Beginner");
		ArrayList<IQuestion> soru = null;

		DragDropMemory d = new DragDropMemory("asd","asd",new ArrayList<Box>());

		c.addDragDropQuestion(d);
		c.addFillBlankQuestion(b);
		c.addMultipleChooiceQuestion(a);


		 //c.closeServer();

	}
}
