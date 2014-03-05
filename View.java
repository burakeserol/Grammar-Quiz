import java.security.AllPermission;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class View {
	private Controller controller;
	private JFrame frame;
	private ViewCategoryPanel viewCategoryPanel;
	private ViewStudyModePanel viewStudyModePanel;
	private ViewLevelSelectPanel viewLevelSelectPanel;
	private ViewGrammarQuestionPanel viewGrammarQuestionPanel;
	private ViewTeacherModePanel viewTeacherModePanel;
	private ViewAddQuestionPanel viewAddQuestionPanel;
	private ViewAddQuestionPreviewDialog viewAddQuestionPreviewDialog;
	private ViewAddEditSelectPanel viewAddEditSelectPanel;
	private ViewEditQuestionPanel viewEditQuestionPanel;
	private ViewDiagnoseModePanel viewDiagnoseModePanel; //burak
	private ViewDiagnoseResultPanel viewDiagnoseResultPanel;

	public View(Controller controller) {

		this.controller = controller;
		this.frame = new JFrame("Grammar Quiz");
		this.viewCategoryPanel = new ViewCategoryPanel(controller);
		this.viewStudyModePanel = new ViewStudyModePanel(controller);
		this.viewLevelSelectPanel = new ViewLevelSelectPanel(controller);
		this.viewGrammarQuestionPanel = new ViewGrammarQuestionPanel(controller);
		this.viewTeacherModePanel = new ViewTeacherModePanel(controller);
		this.viewAddQuestionPanel = new ViewAddQuestionPanel(controller);
		this.viewAddQuestionPreviewDialog = new ViewAddQuestionPreviewDialog(
				controller);
		this.viewAddEditSelectPanel = new ViewAddEditSelectPanel(controller);
		this.viewEditQuestionPanel = new ViewEditQuestionPanel(controller);
		this.viewDiagnoseModePanel = new ViewDiagnoseModePanel(controller); //burak
		this.viewDiagnoseResultPanel = new ViewDiagnoseResultPanel(controller);


		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50, 50, 800, 600);
		frame.setResizable(false);

		changePanel(viewCategoryPanel);
	}

	public void Update() {
		choosePanel(controller.getChoosenPanelName());
		viewGrammarQuestionPanel.Update();
		viewTeacherModePanel.Update();
		viewAddQuestionPreviewDialog.Update();
	}

	private void choosePanel(String choosenPanelName) {
		if (choosenPanelName.equals("DiagnosticModePanel")) {
			changePanel(viewDiagnoseModePanel);
		} else if (choosenPanelName.equals("StudyModePanel")) {
			changePanel(viewStudyModePanel);
		} else if (choosenPanelName.equals("QuizModePanel")) {
			// changePanel(viewQuizModePanel);
		} else if (choosenPanelName.equals("TeacherModePanel")) {
			changePanel(viewTeacherModePanel);
		} else if (choosenPanelName.equals("CategoryPanel")) {
			changePanel(viewCategoryPanel);
		} else if (choosenPanelName.equals("LevelSelectPanel")) {
			changePanel(viewLevelSelectPanel);
		} else if (choosenPanelName.equals("GrammarQuestionPanel")) {
			changePanel(viewGrammarQuestionPanel);
		} else if (choosenPanelName.equals("AddQuestionPanel")) {
			changePanel(viewAddQuestionPanel);
		} else if (choosenPanelName.equals("AddEditSelectPanel")) {
			changePanel(viewAddEditSelectPanel);
		} else if (choosenPanelName.equals("EditQuestionPanel")) {
			changePanel(viewEditQuestionPanel);
		} else if (choosenPanelName.equals("DiagnoseResultPanel")){
			changePanel(viewDiagnoseResultPanel);
		}
	}

	public void setAllFillBlankQuestion(ArrayList<IQuestion> allFillBlankQuestion) {
		viewEditQuestionPanel.setAllFillBlankQuestion(allFillBlankQuestion);
	}
	public void setAllMultipleChoiceQuestion(ArrayList<IQuestion> allMultipleChoiceQuestion) {
		viewEditQuestionPanel.setAllMultipleChoiceQuestion(allMultipleChoiceQuestion);
	}

	public int getFillBlankNumberOfDeletedQuestion() {
		return viewEditQuestionPanel.getFillBlankNumberOfDeletedQuestion();
	}
	public int getMultipleChoiceNumberOfDeletedQuestion() {
		return viewEditQuestionPanel.getMultipleChoiceNumberOfDeletedQuestion();
	}

	public void changePanel(JPanel panel) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.revalidate();
		frame.repaint();

		System.out.println("ss");
	}

	private void changePanel(JTabbedPane panel) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.revalidate();
		frame.repaint();

	}

	public ViewAddQuestionPanel getViewAddQuestionPanel() {
		return viewAddQuestionPanel;
	}

	public void setDialogVisible(boolean b){
		viewAddQuestionPreviewDialog.setVisible(b);
	}

	public void setRandomQuestion( ArrayList<IQuestion> list)
	{
		viewDiagnoseModePanel.getRandomQuestions(list);
	}

	public void setAllScore( int presentScore,int presentPerfectScore, int pastScore, int pastPerfectScore, int futureScore)
	{
		this.viewDiagnoseResultPanel = new ViewDiagnoseResultPanel(controller);
		viewDiagnoseResultPanel.createChart(presentScore, presentPerfectScore, pastScore, pastPerfectScore, futureScore);
	}

	public String getUrlText(){
		return viewAddQuestionPanel.getUrlText();
	}
	public String getTitleText(){
		return viewAddQuestionPanel.getTitleText();
	}

	public int getDragDropNumberOfDeleted() {
		// TODO Auto-generated method stub
		return viewEditQuestionPanel.getDragDropNumberOfDeletedQuestion();
	}

	public void setAllDragDropQuestion(
			ArrayList<DragDropMemory> dragDropQuestions) {
		viewEditQuestionPanel.setAllDragDropQuestion(dragDropQuestions);

	}


}
