import java.io.Serializable;

import javax.swing.JPanel;


abstract public class IQuestion extends JPanel implements Serializable{

	public abstract void reset();

	public abstract boolean answerControl();

	public abstract void showAnswer(boolean b);

}
