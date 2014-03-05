import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ViewEditDragAndDropQuestionTab extends JPanel  {
	private ViewEditDragDropSperateQuestionPanel dragDropSeperatePanel;
	private Controller controller;
	private ArrayList<DragDropMemory> allDragDropQuestion;
	private JPanel p;
	private JScrollPane scroolPane;

	public ViewEditDragAndDropQuestionTab(Controller controller) {
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

	public int getNumberOfDeletedQuestion() {
		return dragDropSeperatePanel.getNumberOfDeletedQuestion();
	}

	public ArrayList<DragDropMemory> getAllFillBlankQuestion() {
		return allDragDropQuestion;
	}

	public void setAllDragDropQuestion(
			ArrayList<DragDropMemory> allFillBlankQuestion) {
		p.removeAll();
		this.allDragDropQuestion = allFillBlankQuestion;

		for (int i = 0; i < allFillBlankQuestion.size(); i++) {
			DragDropMemory b = (DragDropMemory) allFillBlankQuestion
					.get(i);
			System.out.println(b.getTitle());
			dragDropSeperatePanel = new ViewEditDragDropSperateQuestionPanel(controller,
					b.getTitle(), i);
			p.add(dragDropSeperatePanel);
		}

	}
}
