import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class ViewStudyModePanel extends JPanel {

	public ViewStudyModePanel(Controller controller) {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 250, 100, 250, 100 };
		gridBagLayout.rowHeights = new int[] { 60, 60, 300, 60, 60, 60 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0 };

		DefaultListModel<String> grammerList;
		grammerList = new DefaultListModel<String>();
		grammerList.addElement("Present Tenses");
		grammerList.addElement("Present Perfect Tenses");
		grammerList.addElement("Past Tenses");
		grammerList.addElement("Past Perfect Tenses");
		grammerList.addElement("Future Tenses");

		DefaultListModel<String> vocabList;
		vocabList = new DefaultListModel<String>();
		vocabList.addElement("Vocabulary");

		JLabel lblNewLabel = new JLabel("Grammar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;

		JLabel lblNewLabel_1 = new JLabel("Vocabulary");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;

		JList list = new JList(grammerList);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list.setBackground(SystemColor.info);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JList list1 = new JList(vocabList);
		list1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		list1.setBackground(SystemColor.info);
		GridBagConstraints gbc_list1 = new GridBagConstraints();
		gbc_list1.gridy = 2;
		gbc_list1.insets = new Insets(0, 0, 5, 5);
		gbc_list1.fill = GridBagConstraints.BOTH;
		gbc_list1.gridx = 3;
		gbc_list.gridy = 2;

		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 5;
		btnBack.addActionListener(controller);
		btnBack.setActionCommand("BackToCategoryPanel");

		list.addMouseListener(controller);
		list1.addMouseListener(controller);

		setLayout(gridBagLayout);
		setBackground(new Color(240, 255, 255));
		setPreferredSize(new Dimension(800, 600));
		setBorder(new EmptyBorder(5, 5, 5, 5));

		add(lblNewLabel, gbc_lblNewLabel);
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		add(list, gbc_list);
		add(list1, gbc_list1);
		add(btnBack, gbc_btnBack);
	}

}
