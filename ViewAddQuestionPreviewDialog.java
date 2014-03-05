import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewAddQuestionPreviewDialog extends JDialog {
	private JPanel scrollPane;
	private Controller controller;

	public ViewAddQuestionPreviewDialog(Controller controller) {
		this.controller = controller;
		setBackground(new Color(240, 255, 255));
		setPreferredSize(new Dimension(400, 150));
		setLayout(new BorderLayout());
		setResizable(false);

		scrollPane = new JPanel();
		scrollPane.setLayout(new BoxLayout(scrollPane, BoxLayout.Y_AXIS));

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();

		add(scrollPane, BorderLayout.NORTH);
		addWindowListener(controller);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setActionCommand("PreviewSubmit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(controller);
		JButton btnNewButton1 = new JButton("Show Answer");
		btnNewButton1.setActionCommand("PreviewShowAnswer");
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton1.addActionListener(controller);

		JPanel p = new JPanel();
		p.add(btnNewButton);
		//p.add(btnNewButton1);
		add(p, BorderLayout.SOUTH);


		pack();
	}

	public void Update() {
		if (controller.getSampleQuestion() != null) {
			showedQuestion(controller.getSampleQuestion());
		}
		else
			scrollPane.removeAll();
	}

	public void showedQuestion(IQuestion question) {
		scrollPane.removeAll();
		scrollPane.add((Component) question);

	}
}
