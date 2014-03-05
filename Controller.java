import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Controller implements ActionListener, MouseListener,
		WindowListener {
	private View view;
	private Model model;

	private FileOutputStream fOut;
	private ObjectOutputStream out;

	private String passwordText;
	private String choosenPanelName;
	private ArrayList<IQuestion> questions;
	private IQuestion sampleQuestion;

	private boolean dialogVisible;

	public void report() {
		questions = model.getChoosenQuestions();
		choosenPanelName = model.getChoosenPanelName();
		passwordText = model.getPasswordText();
		view.Update();
	}

	public void addView(View view) {
		this.view = view;

	}

	public void addModel(Model model) {
		this.model = model;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Diagnostic Mode")) {
			model.changePanel("DiagnosticModePanel");
			view.setRandomQuestion(model.getRandomQuestions());

		} else if (e.getActionCommand().equals("Study Mode")) {
			model.changePanel("StudyModePanel");
		} else if (e.getActionCommand().equals("Quiz Mode")) {
			model.changePanel("QuizModePanel");
		} else if (e.getActionCommand().equals("Teacher Mode")) {
			model.changePanel("TeacherModePanel");
		} else if (e.getActionCommand().equals("BackToCategoryPanel")) {
			model.setPasswordText(true);
			model.changePanel("CategoryPanel");
		} else if (e.getActionCommand().equals("BackToStudyModePanel")) {
			model.changePanel("StudyModePanel");
		} else if (e.getActionCommand().equals("BackToLevelSelectPanel")) {
			model.changePanel("LevelSelectPanel");
		} else if (e.getActionCommand().equals("Beginner")) {
			model.setQuestionDifficulty("Beginner");
			model.chooseNewQuestions();
			report();
			model.changePanel("GrammarQuestionPanel");
		} else if (e.getActionCommand().equals("Intermediate")) {
			model.setQuestionDifficulty("Intermediate");
			model.chooseNewQuestions();
			report();
			model.changePanel("GrammarQuestionPanel");
		} else if (e.getActionCommand().equals("Advance")) {
			model.setQuestionDifficulty("Advance");
			model.chooseNewQuestions();
			report();
			model.changePanel("GrammarQuestionPanel");
		} else if (e.getActionCommand().equals("Submit")) {
			model.controlAnswer();
		} else if (e.getActionCommand().equals("Next")) {
			view.setAllScore(model.presentScore(), model.presentPerfectScore(),
					model.pastScore(), model.pastPerfectScore(),
					model.futureScore());
			model.changePanel("DiagnoseResultPanel");
		} else if (e.getActionCommand().equals("Show Answer")) {
			model.showAnswer();
		} else if (e.getActionCommand().equals("Try Another")) {
			model.chooseNewQuestions();
		} else if (e.getActionCommand().equals("EnterPassword")) {
			try {
				model.accessSecurePanel(
						((JPasswordField) e.getSource()).getText(),
						"AddEditSelectPanel");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			((JPasswordField) e.getSource()).setText("");
		} else if (e.getActionCommand().equals("FillBlankAddQuestion")
				|| e.getActionCommand().equals("FillBlankPreviewQuestion")) {
			if (view.getViewAddQuestionPanel().getFillBlankQuestion()
					.getTextAnswer().getText().length() != 0) {
				if (view.getViewAddQuestionPanel().getFillBlankQuestion()
						.getTextAnswer().getText().charAt(0) != ' ') {
					GrammarFillBlankQuestion q = new GrammarFillBlankQuestion(
							view.getViewAddQuestionPanel()
									.getFillBlankQuestion().getRightPanel()
									.getTag(), view.getViewAddQuestionPanel()
									.getFillBlankQuestion().getTextAnswer()
									.getText(), view.getViewAddQuestionPanel()
									.getFillBlankQuestion().getTextBefore()
									.getText()
									+ " - "
									+ view.getViewAddQuestionPanel()
											.getFillBlankQuestion()
											.getTextAfter().getText(), view
									.getViewAddQuestionPanel()
									.getFillBlankQuestion().getRightPanel()
									.getDif());
					if (e.getActionCommand().equals("FillBlankAddQuestion")) {
						try {
							model.addFillBlankQuestion(q);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(new JFrame(""),
								"Question added successfully");
					} else {
						sampleQuestion = q;
						report();
						view.setDialogVisible(true);
					}

				}
			}
		} else if (e.getActionCommand().equals("MultipleChoiceAddQuestion")
				|| e.getActionCommand().equals("MultipleChoicePreviewQuestion")) {
			if (view.getViewAddQuestionPanel().getMultipleChoiceQuestion()
					.getTextAnswer().getText().length() != 0
					&& view.getViewAddQuestionPanel()
							.getMultipleChoiceQuestion().getTextOption1()
							.getText().length() != 0
					&& view.getViewAddQuestionPanel()
							.getMultipleChoiceQuestion().getTextOption2()
							.getText().length() != 0) {
				if (view.getViewAddQuestionPanel().getMultipleChoiceQuestion()
						.getTextAnswer().getText().charAt(0) != ' ') {
					GrammarComboBoxQuestion q = new GrammarComboBoxQuestion(
							view.getViewAddQuestionPanel()
									.getMultipleChoiceQuestion()
									.getRightPanel().getTag(), view
									.getViewAddQuestionPanel()
									.getMultipleChoiceQuestion()
									.getTextAnswer().getText(), view
									.getViewAddQuestionPanel()
									.getMultipleChoiceQuestion()
									.getTextOption1().getText(), view
									.getViewAddQuestionPanel()
									.getMultipleChoiceQuestion()
									.getTextOption2().getText(), view
									.getViewAddQuestionPanel()
									.getMultipleChoiceQuestion()
									.getTextBefore().getText()
									+ " - "
									+ view.getViewAddQuestionPanel()
											.getMultipleChoiceQuestion()
											.getTextAfter().getText(), view
									.getViewAddQuestionPanel()
									.getMultipleChoiceQuestion()
									.getRightPanel().getDif());
					if (e.getActionCommand()
							.equals("MultipleChoiceAddQuestion")) {
						// modelde write object
						try {
							model.addMultipleChooiceQuestion(q);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(new JFrame(""),
								"Question added successfully");
					} else {
						sampleQuestion = q;
						report();
						view.setDialogVisible(true);
					}

				}
			}
		} else if (e.getActionCommand().equals("PreviewSubmit")) {
			sampleQuestion.answerControl();

		} else if (e.getActionCommand().equals("PreviewShowAnswer")) {
			sampleQuestion.showAnswer(true);
		} else if (e.getActionCommand().equals("Add Question")) {
			model.changePanel("AddQuestionPanel");
		} else if (e.getActionCommand().equals("BackToTeacherModePanel")) {
			model.changePanel("TeacherModePanel");
		} else if (e.getActionCommand().equals("BackToAddEditPanel")) {
			model.changePanel("AddEditSelectPanel");
		} else if (e.getActionCommand().equals("Edit Question")) {
			view.setAllFillBlankQuestion(model.getAllFillBlankQuestions());
			view.setAllMultipleChoiceQuestion(model
					.getAllMultipleChoiceQuestions());
			view.setAllDragDropQuestion(model.getAllDragDropQuestions());
			model.changePanel("EditQuestionPanel");
		} else if (e.getActionCommand().equals("DeleteFillBlankQuestion")) {
			model.deleteFillBlankQuestion(view
					.getFillBlankNumberOfDeletedQuestion());
			view.setAllFillBlankQuestion(model.getAllFillBlankQuestions());
		} else if (e.getActionCommand().equals("DeleteMultipleChoiceQuestion")) {
			model.deleteMultipleChoiceQuestion(view
					.getMultipleChoiceNumberOfDeletedQuestion());
			view.setAllMultipleChoiceQuestion(model
					.getAllMultipleChoiceQuestions());
		} else if (e.getActionCommand().equals("DeleteDragDropQuestion")) {
			model.deleteDragDropQuestion(view.getDragDropNumberOfDeleted());
			view.setAllDragDropQuestion(model
					.getAllDragDropQuestions());
		} else if (e.getActionCommand().equals("DragAndDropAddQuestion")) {
			String Url = view.getUrlText();
			String title = view.getTitleText();
			model.createEmptyDragAndDropQuestion(this, title, Url, true);
			view.changePanel(model.getEmptyDragDropQuestion());
		} else if (e.getActionCommand().equals("AddDragAndDrop")) {
			try {
				model.addDragDropQuestion();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("Skip")) {
			view.changePanel(model.getRandomDragDrop());
		}

		if (!e.getActionCommand().equals("DragAndDropAddQuestion") && !e.getActionCommand().equals("Skip")) {
			report();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JList theList = (JList) e.getSource();
		if (e.getClickCount() == 2) {
			int index = theList.locationToIndex(e.getPoint());
			if (index >= 0) {
				Object o = theList.getModel().getElementAt(index);
				model.setQusetionTag(o.toString());
				if (o.toString().equals("Vocabulary")) {
					view.changePanel(model.getRandomDragDrop());

				} else {
					model.changePanel("LevelSelectPanel");
					report();
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public String getPasswordText() {
		return passwordText;
	}

	public String getChoosenPanelName() {
		return choosenPanelName;
	}

	public ArrayList<IQuestion> getQuestions() {
		return questions;
	}

	public IQuestion getSampleQuestion() {
		return sampleQuestion;
	}

	public void setFillDelete(int i){
		model.deleteFillBlankQuestion(i);
		view.setAllFillBlankQuestion(model.getAllFillBlankQuestions());
	}
public void setMultiDelete(int i){
		model.deleteMultipleChoiceQuestion(i);
		view.setAllMultipleChoiceQuestion(model.getAllMultipleChoiceQuestions());
	}
public void setDragDelete(int i){

	model.deleteDragDropQuestion(i);
	view.setAllDragDropQuestion(model.getAllDragDropQuestions());
}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
