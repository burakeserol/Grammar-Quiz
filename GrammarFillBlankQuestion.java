import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GrammarFillBlankQuestion extends IQuestion {
	private String tag;
	private String answer;
	private String question;
	private String difficulty;
	private int placeOfBlank;
	private JTextField field;
	private boolean answerShowed;
	private JLabel answerLabel;

	public GrammarFillBlankQuestion(String tag, String answer, String question,
			String difficulty) {
		super();
		this.tag = tag;
		this.answer = answer;
		this.question = question;
		this.difficulty = difficulty;
		this.answerShowed = false;
		answerLabel = new JLabel(this.answer);

		for (int i = 0; i < question.length(); i++) {
			if (question.charAt(i) == '-') {
				placeOfBlank = i;
				i = question.length();
			}
		}
		String firstPart = question.substring(0, placeOfBlank);
		String secondPart = question.substring(placeOfBlank + 1);

		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel first = new JLabel(firstPart);
		JLabel second = new JLabel(secondPart);
		first.setFont(new Font("Tahoma", Font.BOLD, 15));
		second.setFont(new Font("Tahoma", Font.BOLD, 15));

		field = new JTextField();
		field.setPreferredSize(new Dimension(50, 20));
		add(first);
		add(field);
		add(second);
	}

	public void reset() {
		field.setBackground(Color.WHITE);
		field.setText("");
		showAnswer(false);
	}

	public boolean answerControl() {
		String answer = field.getText();
		if (answer.equalsIgnoreCase(this.answer)) {
			field.setBackground(Color.GREEN);
			return true;
		} else {
			field.setBackground(Color.RED);
			return false;
		}
	}

	public void showAnswer(boolean showOrNotShow) {

		if (showOrNotShow == true) {
			if (!answerShowed) {
				answerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
				answerLabel.setForeground(Color.GREEN);
				add(answerLabel);
				answerShowed = true;
			}
		} else {
			if (answerShowed) {
				remove(answerLabel);
				answerShowed = false;
			}
		}
		revalidate();
		repaint();
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getPlaceOfBlank() {
		return placeOfBlank;
	}

	public void setPlaceOfBlank(int placeOfBlank) {
		this.placeOfBlank = placeOfBlank;
	}
}
