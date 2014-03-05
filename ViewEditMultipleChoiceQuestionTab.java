import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ViewEditMultipleChoiceQuestionTab extends JPanel {

	private Controller controller;
	private ArrayList<IQuestion> allMultipleChoiceQuestion;
	private JPanel p;
	private JScrollPane scroolPane;
	private ViewEditMultipleChoiceSperateQuestionPanel seperatePanel;

	public ViewEditMultipleChoiceQuestionTab(Controller controller) {
		this.controller = controller;
		p = new JPanel();
		BoxLayout layout = new BoxLayout(p, BoxLayout.Y_AXIS);
		p.setLayout(layout);
		scroolPane = new JScrollPane(p);
		scroolPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroolPane.setVisible(true);
		scroolPane.setPreferredSize(new Dimension(770, 500));

		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		JButton button = new JButton("Back");
		button.setActionCommand("BackToAddEditPanel");
		button.addActionListener(controller);
		bottom.add(button, BorderLayout.WEST);


		add(scroolPane);
		add(bottom);

	}

	public ArrayList<IQuestion> getAllMultipleChoiceQuestion() {
		return allMultipleChoiceQuestion;
	}

	public void setMultipleChoiceQuestion(
			ArrayList<IQuestion> allMultipleChoiceQuestion) {
		p.removeAll();
		this.allMultipleChoiceQuestion = allMultipleChoiceQuestion;

		for (int i = 0; i < allMultipleChoiceQuestion.size(); i++) {
			GrammarComboBoxQuestion b = (GrammarComboBoxQuestion) allMultipleChoiceQuestion
					.get(i);
			System.out.println(b.getQuestion());
			seperatePanel = new ViewEditMultipleChoiceSperateQuestionPanel(controller,
					b.getQuestion(), i);
			p.add(seperatePanel);
		}

	}

	public int getNumberOfDeletedQuestion() {
		return seperatePanel.getNumberOfDeletedQuestion();
	}
}
