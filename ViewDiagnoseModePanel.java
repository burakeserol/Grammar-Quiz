import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class ViewDiagnoseModePanel extends JPanel
{
	Controller controller;
	private JPanel panel;
	private ArrayList<IQuestion> questions;
	private Random generator;
	private JScrollPane scroolPane;

	public ViewDiagnoseModePanel( Controller controller)
	{
		this.controller = controller;

		generator = new Random();

		setBackground(new Color(240, 255, 255));
		setPreferredSize(new Dimension(800, 600));
		setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 660, 50 };
		gridBagLayout.rowHeights = new int[] { 25, 450, 65, 50 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);


		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		scroolPane = new JScrollPane(panel);
		scroolPane
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
scroolPane.setVisible(true);
scroolPane.setPreferredSize(new Dimension(770, 500));

		/*scrollPane = new JScrollPane( panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		scrollPane.setPreferredSize(new Dimension(770, 500));
		*/
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scroolPane, gbc_scrollPane);

		JButton btnNewButton = new JButton("Next");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.CENTER;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 10);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(controller);


		JButton btnNewButtoni = new JButton("Back");
		btnNewButtoni.setActionCommand("BackToCategoryPanel");
		btnNewButtoni.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnNewButtoni = new GridBagConstraints();
		gbc_btnNewButtoni.anchor = GridBagConstraints.WEST;
		gbc_btnNewButtoni.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButtoni.gridx = 0;
		gbc_btnNewButtoni.gridy = 3;
		add(btnNewButtoni, gbc_btnNewButtoni);
		btnNewButtoni.addActionListener(controller);

		JLabel lblNewLabel = new JLabel( "You are given questions from different tenses to diagnose yourself. Good Luck!");
		lblNewLabel.setFont( new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets( 0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		add( lblNewLabel, gbc_lblNewLabel);	

		//add( scrollPane );
	}

	public void getRandomQuestions( ArrayList<IQuestion> list)
	{
		panel.removeAll();
		int  size= list.size();
		int random;
		for (int i = 0; i < 15; i++) 
		{
			random = i;

			random = generator.nextInt( size);
			IQuestion q = (IQuestion) list.get( random);
			q.reset();
			panel.add(q);
			list.remove( random);
			size--;
		}

	}
}
