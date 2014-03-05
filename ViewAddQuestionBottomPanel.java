import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewAddQuestionBottomPanel extends JPanel {
	private JButton addButton;
	private JButton previewButton;
	private JButton backButton;

	public ViewAddQuestionBottomPanel(ActionListener s, String questionType) {


		addButton = new JButton("ADD QUESTION");
		addButton.setActionCommand(questionType + "AddQuestion");
		previewButton = new JButton("PREVIEW QUESTION");
		previewButton.setActionCommand(questionType + "PreviewQuestion");
		backButton = new JButton("Back");
		backButton.setActionCommand("BackToAddEditPanel");
		backButton.addActionListener(s);
		addButton.addActionListener(s);
		previewButton.addActionListener(s);
		setPreferredSize(new Dimension(600, 50));
		setBorder(BorderFactory.createEtchedBorder());


		add(backButton);
		add(Box.createRigidArea(new Dimension(30, 10)));
		add(addButton);
		add(Box.createRigidArea(new Dimension(30, 10)));
		//add(Box.createRigidArea(new Dimension(150, 10)));
		add(previewButton);
		//add(Box.createRigidArea(new Dimension(150, 10)));
	}

	public void DragMode(){
		previewButton.setVisible(false);
	}

}
