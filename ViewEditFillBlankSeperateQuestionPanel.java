import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ViewEditFillBlankSperateQuestionPanel extends JPanel{
	private int numberOfDeletedQuestion;
	private boolean delete;

	public ViewEditFillBlankSperateQuestionPanel(final Controller controller, String question, final int numberOfDeletedQuestion){
		delete = false;
		this.numberOfDeletedQuestion = numberOfDeletedQuestion;
		JLabel label = new JLabel(question);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.setPreferredSize(new Dimension(700,50));

		setLayout(new BorderLayout());
		URL url = getClass().getClassLoader().getResource("images/delete.png");
		Icon imgicon = new ImageIcon(url);
		JButton b = new JButton();
		b.setIcon(imgicon);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.setFillDelete(numberOfDeletedQuestion);

			}
		});
		b.setActionCommand("DeleteFillBlankQuestion");
		setBorder(BorderFactory.createEtchedBorder());

		add(label, BorderLayout.WEST);
		add(b, BorderLayout.EAST);
	}

	public boolean getNumberOfDeletedQuestion() {
		return delete;
	}
}
