import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewCategoryPanel extends JPanel {

	public ViewCategoryPanel(Controller controller) {

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 160, 160, 160, 160, 160 };
		gbl_contentPane.rowHeights = new int[] { 60, 60, 60, 60, 60, 60, 60,
				60, 60, 60 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0 };

		JLabel lblNewLabel = new JLabel("GRAMMAR QUIZ");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;

		// Diagnose Mode Button

		JButton btnNewButton = new JButton("Diagnostic Mode");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setSize(100, 100);
		btnNewButton.addActionListener(controller);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;

		// Study Mode Button
		JButton btnNewButton_1 = new JButton("Study Mode");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(controller);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 5;
/*
		// Quiz Mode Button
		JButton btnNewButton_2 = new JButton("Quiz Mode");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(controller);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 7;
*/
		// Teacher Mode Button
		JButton btnNewButton_3 = new JButton("Teacher Mode");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(controller);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 9;

		setLayout(gbl_contentPane);
		setBackground(new Color(240, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));

		add(lblNewLabel, gbc_lblNewLabel);
		add(btnNewButton, gbc_btnNewButton);
		add(btnNewButton_1, gbc_btnNewButton_1);
		//add(btnNewButton_2, gbc_btnNewButton_2);
		add(btnNewButton_3, gbc_btnNewButton_3);

	}

	public void Update() {

	}

}
