import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewLevelSelectPanel extends JPanel {
	public ViewLevelSelectPanel(Controller controller) {

		setBackground(new Color(240, 255, 255));
		setPreferredSize(new Dimension(800, 600));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 160, 130, 220, 130, 160 };
		gridBagLayout.rowHeights = new int[] { 60, 60, 60, 60, 60, 60, 60, 60,
				60, 60 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblChoose = new JLabel("Choose Your Level");
		lblChoose.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblChoose = new GridBagConstraints();
		gbc_lblChoose.insets = new Insets(0, 0, 5, 5);
		gbc_lblChoose.gridx = 2;
		gbc_lblChoose.gridy = 1;
		add(lblChoose, gbc_lblChoose);

		JButton btnNewButton = new JButton("Beginner");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setSize(100, 100);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(controller);

		JButton btnNewButton_1 = new JButton("Intermediate");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 5;
		add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(controller);

		JButton btnNewButton_2 = new JButton("Advance");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 7;
		add(btnNewButton_2, gbc_btnNewButton_2);
		btnNewButton_2.addActionListener(controller);

		JButton btnNewButtoni = new JButton("Back");
		btnNewButtoni.setActionCommand("BackToStudyModePanel");
		btnNewButtoni.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnNewButtoni = new GridBagConstraints();
		gbc_btnNewButtoni.anchor = GridBagConstraints.WEST;
		gbc_btnNewButtoni.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButtoni.gridx = 0;
		gbc_btnNewButtoni.gridy = 9;
		add(btnNewButtoni, gbc_btnNewButtoni);
		btnNewButtoni.addActionListener(controller);

	}

}
