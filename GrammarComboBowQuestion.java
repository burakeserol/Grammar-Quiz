import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GrammarComboBoxQuestion extends IQuestion {
	private String tag;
	private String question;

	// Combo box elemanlar�, option1 ve option2 yanl�� olan cevaplar.
	private String answer;
	private String option1;
	private String option2;
	private String difficulty;

	private int placeOfBlank;
	private boolean answerShowed;

	private JComboBox comboBox;
	private JLabel answerLabel;
	private ArrayList<String> comboElements;

	private Random generator;

	public GrammarComboBoxQuestion(String tag, String answer, String option1,
			String option2, String question, String difficulty) {
		this.tag = tag;
		this.answer = answer;
		this.option1 = option1;
		this.option2 = option2;
		this.question = question;
		this.difficulty = difficulty;
		this.answerShowed = false;
		this.answerLabel = new JLabel(this.answer);

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

		comboElements = new ArrayList<String>();
		comboElements.add(answer);
		comboElements.add(option1);
		comboElements.add(option2);

		comboBox = new JComboBox();
		generator = new Random();

		// her seferinde combo box'a farkl� s�rayla ats�n diye.
		for (int i = 0; i < comboElements.size(); i++) {
			int a = generator.nextInt(comboElements.size());
			comboBox.addItem(comboElements.get(a));
			comboElements.remove(a);

			if (i == 1) {
				i = comboElements.size();
				comboBox.addItem(comboElements.get(0));
			}
		}

		add(first);
		add(comboBox);
		add(second);
	}

	public void reset() {
		comboBox.setBackground(Color.WHITE);
		showAnswer(false);
	}

	public boolean answerControl() {
		String answer = (String) comboBox.getSelectedItem();
		if (answer.equalsIgnoreCase(this.answer)) {
			comboBox.setBackground(Color.GREEN);
			return true;
		} else {
			comboBox.setBackground(Color.RED);
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
