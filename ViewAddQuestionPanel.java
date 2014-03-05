import java.awt.Dimension;

import javax.swing.JTabbedPane;

public class ViewAddQuestionPanel extends JTabbedPane {
	private ViewAddMultipleChoiceQuestionTab multipleChoiceQuestion;
	private ViewAddFillBlankQuestionTab fillBlankQuestion;
	private ViewAddDragAndDropQuestionTab dragAndDrop;

	public ViewAddQuestionPanel(Controller controller) {
		setPreferredSize(new Dimension(800, 600));
		multipleChoiceQuestion = new ViewAddMultipleChoiceQuestionTab(
				controller);
		fillBlankQuestion = new ViewAddFillBlankQuestionTab(controller);
		dragAndDrop = new ViewAddDragAndDropQuestionTab(controller);
		this.addTab("Fill in the Blank", fillBlankQuestion);
		this.addTab("Multiple Choice", multipleChoiceQuestion);
		this.addTab("Drag and Drop", dragAndDrop);
	}

	public ViewAddMultipleChoiceQuestionTab getMultipleChoiceQuestion() {
		return multipleChoiceQuestion;
	}

	public ViewAddFillBlankQuestionTab getFillBlankQuestion() {
		return fillBlankQuestion;
	}

	public ViewAddDragAndDropQuestionTab getDragAndDrop() {
		return dragAndDrop;
	}

	public String getUrlText(){
		return dragAndDrop.getUrlText();
	}
	public String getTitleText(){
		return dragAndDrop.getTitleText();
	}

}
