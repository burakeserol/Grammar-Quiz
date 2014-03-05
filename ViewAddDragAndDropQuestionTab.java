import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewAddDragAndDropQuestionTab extends JPanel {
	ViewAddQuestionBottomPanel bottomPanel;

	JPanel url;
	JLabel urlLabel;
	JTextField urlText;
	JLabel titleLabel;
	JTextField titleText;

	public ViewAddDragAndDropQuestionTab(Controller controller) {
		setLayout(new BorderLayout());
		bottomPanel = new ViewAddQuestionBottomPanel(controller, "DragAndDrop");
		bottomPanel.DragMode();
		add(bottomPanel, BorderLayout.SOUTH);

		/*JButton b = new JButton("Next");
		b.setActionCommand("NextDragDrop");
		b.addActionListener(controller);
		*/
		url = new JPanel();
		url.setBorder(BorderFactory.createTitledBorder("URL and Title"));
		urlLabel = new JLabel("Enter image's url:");
		titleLabel = new JLabel("Enter question title: ");
		urlText = new JTextField(20);
		titleText = new JTextField(20);
		url.add(urlLabel);
		url.add(urlText);
		url.add(titleLabel);
		url.add(titleText);
		//url.add(b, BorderLayout.SOUTH);
		add(url, BorderLayout.NORTH);
	}

	public String getUrlText(){
		return urlText.getText();
	}
	public String getTitleText(){
		return titleText.getText();
	}

}
