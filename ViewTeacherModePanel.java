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
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewTeacherModePanel extends JPanel {
	private Controller controller;
	private JPasswordField passwordField;
	private JLabel btnEnter;

	/***
	 * Create the panel.
	 */
	public ViewTeacherModePanel(Controller controller) {
		this.controller = controller;
		setBackground(new Color(240, 255, 255));
		setPreferredSize(new Dimension(800, 600));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 160, 160, 160, 160, 160 };
		gridBagLayout.rowHeights = new int[] { 60, 60, 60, 60, 60, 60, 60, 60,
				60, 60 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Enter Teacher Code");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setActionCommand("EnterPassword");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		passwordField.addActionListener(controller);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setActionCommand("BackToCategoryPanel");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 9;
		add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(controller);

		btnEnter = new JLabel("");
		btnEnter.setForeground(Color.RED);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.anchor = GridBagConstraints.NORTH;
		gbc_btnEnter.insets = new Insets(-10, 0, 5, 5);
		gbc_btnEnter.gridx = 2;
		gbc_btnEnter.gridy = 5;
		add(btnEnter, gbc_btnEnter);
	}

	public void Update() {
		btnEnter.setText(controller.getPasswordText());

	}
}
