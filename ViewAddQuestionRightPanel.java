import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewAddQuestionRightPanel extends JPanel {
	private JComboBox boxTag;
	private JComboBox boxDifficulty;
	private JLabel label;

	public ViewAddQuestionRightPanel() {
		label = new JLabel("");
		setLayout(new GridLayout(20, 1));
		boxTag = new JComboBox();
		boxDifficulty = new JComboBox();
		boxTag.addItem("Present Tenses");
		boxTag.addItem("Present Perfect Tenses");
		boxTag.addItem("Past Tenses");
		boxTag.addItem("Past Perfect Tenses");
		boxTag.addItem("Future Tenses");

		boxDifficulty.addItem("Beginner");
		boxDifficulty.addItem("Intermediate");
		boxDifficulty.addItem("Advance");

		setPreferredSize(new Dimension(150, 400));

		setBorder(BorderFactory.createTitledBorder("Select Tag"));

		add(label);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(boxTag);
		add(label);
		add(boxDifficulty);
	}

	public String getTag() {
		return (String) boxTag.getSelectedItem();
	}

	public String getDif() {
		return (String) boxDifficulty.getSelectedItem();
	}
}
