import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTabbedPane;


public class ViewEditQuestionPanel extends JTabbedPane{

	private ViewEditMultipleChoiceQuestionTab multipleChoiceQuestion;
	private ViewEditFillBlankQuestionTab fillBlankQuestion;
	private ViewEditDragAndDropQuestionTab dragAndDrop;

	public ViewEditQuestionPanel(Controller controller) {
		setPreferredSize(new Dimension(800, 600));
		multipleChoiceQuestion = new ViewEditMultipleChoiceQuestionTab(
				controller);
		fillBlankQuestion = new ViewEditFillBlankQuestionTab(controller);
		dragAndDrop = new ViewEditDragAndDropQuestionTab(controller);
		this.addTab("Fill in the Blank", fillBlankQuestion);
		this.addTab("Multiple Choice", multipleChoiceQuestion);
		this.addTab("Drag and Drop", dragAndDrop);
	}

	public void setAllFillBlankQuestion(ArrayList<IQuestion> allFillBlankQuestion) {
		fillBlankQuestion.setAllFillBlankQuestion(allFillBlankQuestion);
	}

	public void setAllMultipleChoiceQuestion(ArrayList<IQuestion> allMultipleChoiceQuestion) {
		multipleChoiceQuestion.setMultipleChoiceQuestion(allMultipleChoiceQuestion);
	}

	public int getFillBlankNumberOfDeletedQuestion() {
		return fillBlankQuestion.getNumberOfDeletedQuestion();
	}

	public int getMultipleChoiceNumberOfDeletedQuestion() {
		return multipleChoiceQuestion.getNumberOfDeletedQuestion();
	}

	public int getDragDropNumberOfDeletedQuestion() {
		return dragAndDrop.getNumberOfDeletedQuestion();
	}

	public void setAllDragDropQuestion(
			ArrayList<DragDropMemory> dragDropQuestions) {
		dragAndDrop.setAllDragDropQuestion(dragDropQuestions);

	}
}
