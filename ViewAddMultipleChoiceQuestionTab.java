import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewAddMultipleChoiceQuestionTab extends JPanel {

	ViewAddQuestionRightPanel rightPanel;
	ViewAddQuestionBottomPanel bottomPanel;

	JPanel multipleChoicePanel;

	JPanel beforeAnswer;
	JLabel labelBefore;
	JTextField textBefore;

	JPanel afterAnswer;
	JLabel labelAfter;
	JTextField textAfter;

	JPanel answer;
	JLabel labelAnswer;
	JTextField textAnswer;

	JPanel option1;
	JLabel labelOption1;
	JTextField textOption1;

	JPanel option2;
	JLabel labelOption2;
	JTextField textOption2;

	public ViewAddMultipleChoiceQuestionTab(Controller controller) {
		/*
		 * try { fOut=new
		 * FileOutputStream("C:/Users/TEMP/Desktop/multipleChoice.out"); out=new
		 * ObjectOutputStream(fOut); } catch (FileNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		setLayout(new BorderLayout());
		rightPanel = new ViewAddQuestionRightPanel();
		bottomPanel = new ViewAddQuestionBottomPanel(controller,
				"MultipleChoice");
		add(rightPanel, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);

		multipleChoicePanel = new JPanel();

		// cevaptan �ncesi
		beforeAnswer = new JPanel();
		labelBefore = new JLabel("Enter before answer part:");
		textBefore = new JTextField(35);
		beforeAnswer.setBorder(BorderFactory
				.createTitledBorder("Before Answer"));
		beforeAnswer.setPreferredSize(new Dimension(500, 150));
		beforeAnswer.add(labelBefore);
		beforeAnswer.add(textBefore);

		// cevaptan sonras�
		afterAnswer = new JPanel();
		labelAfter = new JLabel("Enter after answer part:");
		textAfter = new JTextField(35);
		afterAnswer.setBorder(BorderFactory.createTitledBorder("After Answer"));
		afterAnswer.setPreferredSize(new Dimension(500, 150));
		afterAnswer.add(labelAfter);
		afterAnswer.add(textAfter);

		// cevap
		answer = new JPanel();
		answer.setBorder(BorderFactory.createTitledBorder("Answer"));
		answer.setPreferredSize(new Dimension(170, 120));
		labelAnswer = new JLabel("Enter Answer:");
		textAnswer = new JTextField(10);
		answer.add(labelAnswer);
		answer.add(textAnswer);

		option1 = new JPanel();
		option1.setBorder(BorderFactory.createTitledBorder("Option1"));
		option1.setPreferredSize(new Dimension(170, 120));
		labelOption1 = new JLabel("Enter Option1:");
		textOption1 = new JTextField(10);
		option1.add(labelOption1);
		option1.add(textOption1);

		option2 = new JPanel();
		option2.setBorder(BorderFactory.createTitledBorder("Option2"));
		option2.setPreferredSize(new Dimension(170, 120));
		labelOption2 = new JLabel("Enter Option2:");
		textOption2 = new JTextField(10);
		option2.add(labelOption2);
		option2.add(textOption2);

		multipleChoicePanel.add(beforeAnswer);
		multipleChoicePanel.add(answer);
		multipleChoicePanel.add(option1);
		multipleChoicePanel.add(option2);
		multipleChoicePanel.add(afterAnswer);

		add(multipleChoicePanel, BorderLayout.CENTER);
	}

	public ViewAddQuestionRightPanel getRightPanel() {
		return rightPanel;
	}

	public JTextField getTextBefore() {
		return textBefore;
	}

	public JTextField getTextAfter() {
		return textAfter;
	}

	public JTextField getTextAnswer() {
		return textAnswer;
	}

	public JTextField getTextOption1() {
		return textOption1;
	}

	public JTextField getTextOption2() {
		return textOption2;
	}

	/*
	 * @Override
	 * 
	 * public void actionPerformed(ActionEvent e) { if
	 * (textAnswer.getText().length() != 0 || textOption1.getText().length() !=
	 * 0 || textOption2.getText().length() != 0) { if
	 * (textAnswer.getText().charAt(0) != ' ') { GrammarComboBoxQuestion q = new
	 * GrammarComboBoxQuestion(rightPanel.getTag(), textAnswer.getText(),
	 * textOption1.getText(), textOption2.getText(), textBefore.getText() +
	 * " - " + textAfter.getText(), rightPanel.getDif()); if
	 * (e.getActionCommand().equals("ADD QUESTION")) { try { out.writeObject(q);
	 * } catch (IOException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } } else if
	 * (e.getActionCommand().equals("PREVIEW QUESTION")) {
	 * dialog.showedQuestion(q); dialog.setVisible(true); } } else {
	 * System.out.println("HATA"); } } else { System.out.println("HATA"); } }
	 */

}
