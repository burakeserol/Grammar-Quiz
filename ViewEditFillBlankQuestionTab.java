import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ViewEditFillBlankQuestionTab extends JPanel {
	private Controller controller;
	private ArrayList<IQuestion> allFillBlankQuestion;
	private JPanel p;
	private JScrollPane scroolPane;
	private ArrayList fillSeperatePanel;

	public ViewEditFillBlankQuestionTab(Controller controller) {
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

	public ArrayList<IQuestion> getAllFillBlankQuestion() {
		return allFillBlankQuestion;
	}

	public void setAllFillBlankQuestion(
			ArrayList<IQuestion> allFillBlankQuestion) {
		p.removeAll();
		this.allFillBlankQuestion = allFillBlankQuestion;

		for (int i = 0; i < allFillBlankQuestion.size(); i++) {
			GrammarFillBlankQuestion b = (GrammarFillBlankQuestion) allFillBlankQuestion
					.get(i);
			System.out.println(b.getQuestion());
			ViewEditFillBlankSperateQuestionPanel q = new ViewEditFillBlankSperateQuestionPanel(
					controller, b.getQuestion(), i);

			p.add(q);
		}

	}

	public int getNumberOfDeletedQuestion() {
		int c = 0;
		for (int i = 0; i < fillSeperatePanel.size(); i++) {

		}
		return c;
	}

}
