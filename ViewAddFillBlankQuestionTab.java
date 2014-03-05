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

public class ViewAddFillBlankQuestionTab extends JPanel {

	ViewAddQuestionRightPanel rightPanel;
	ViewAddQuestionBottomPanel bottomPanel;

	JPanel fillBlankPanel;

	JPanel beforeAnswer;
	JLabel labelBefore;
	JTextField textBefore;

	JPanel afterAnswer;
	JLabel labelAfter;
	JTextField textAfter;

	JPanel answer;
	JLabel labelAnswer;
	JTextField textAnswer;

	public ViewAddFillBlankQuestionTab(Controller controller) {
		setLayout(new BorderLayout());
		/*
		 * try { fOut = new
		 * FileOutputStream("C:/Users/TEMP/Desktop/fillBlank.out"); out = new
		 * ObjectOutputStream(fOut); } catch (FileNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		rightPanel = new ViewAddQuestionRightPanel();
		bottomPanel = new ViewAddQuestionBottomPanel(controller, "FillBlank");
		add(rightPanel, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);

		fillBlankPanel = new JPanel();

		// cevaptan oncesi
		beforeAnswer = new JPanel();
		labelBefore = new JLabel("Enter before answer part:");
		textBefore = new JTextField(35);
		beforeAnswer.setBorder(BorderFactory
				.createTitledBorder("Before Answer"));
		beforeAnswer.setPreferredSize(new Dimension(500, 150));
		beforeAnswer.add(labelBefore);
		beforeAnswer.add(textBefore);

		// cevaptan sonrasi
		afterAnswer = new JPanel();
		labelAfter = new JLabel("Enter after answer part:");
		textAfter = new JTextField(35);
		afterAnswer.setBorder(BorderFactory.createTitledBorder("After Answer"));
		afterAnswer.setPreferredSize(new Dimension(500, 150));
		afterAnswer.add(labelAfter);
		afterAnswer.add(textAfter);

		// cevap
		answer = new JPanel();
		labelAnswer = new JLabel("    Enter Answer:");
		textAnswer = new JTextField(35);
		answer.setBorder(BorderFactory.createTitledBorder("Answer"));
		answer.setPreferredSize(new Dimension(500, 150));
		answer.add(labelAnswer);
		answer.add(textAnswer);

		fillBlankPanel.add(beforeAnswer);
		fillBlankPanel.add(answer);
		fillBlankPanel.add(afterAnswer);

		add(fillBlankPanel, BorderLayout.CENTER);

	}

	// || textAnswer.getText().length() != 0
	/*
	 * @Override public void actionPerformed(ActionEvent e) { if
	 * (textAnswer.getText().length() != 0) { if (textAnswer.getText().charAt(0)
	 * != ' ') { GrammarFillBlankQuestion q = new GrammarFillBlankQuestion(
	 * rightPanel.getTag(), textAnswer.getText(), textBefore.getText() + " - " +
	 * textAfter.getText(), rightPanel.getDif()); if
	 * (e.getActionCommand().equals("ADD QUESTION")) { try { out.writeObject(q);
	 * } catch (IOException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } } else if
	 * (e.getActionCommand().equals("PREVIEW QUESTION")) {
	 * dialog.showedQuestion(q); dialog.setVisible(true); } } else {
	 * System.out.println("HATA"); } } else { System.out.println("HATA"); } }
	 */

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

}
