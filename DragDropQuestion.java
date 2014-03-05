
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DragDropQuestion extends JPanel implements MouseListener, MouseMotionListener 
{
	//  Properties
	private ArrayList<Box>  	as = new ArrayList<Box>();
	private String 			title;
	private String 			Url;
	private Image			image;
	private JButton			but, but2;
	private boolean 	   	evaluate;
	private int			count = 0;
	private int 			v = 0;

	// The collection that holds the questions and answers for the current panel				

	private boolean   		teacherModeEnabled = true;
	private JButton  		removeQuestion = new JButton( "Remove question");
	private int  			num, again;
	private String 			numStr, ansTitle;
	private boolean 		ok;
	private JButton  		preview;
	private int 			correct=0;
	private int 			wrong=0;
	private int 			qNo=0;
	private JButton			submit;
	private int 			next;
	private BufferedImage		img;

	//	Constructor
	public DragDropQuestion( Controller controller,String title, String Url,ArrayList<Box>  as, boolean teacherModeOn) 
	{
		this.Url = Url;
		this.title = title;
		this.as = as;
		try
		{
			img = ImageIO.read( new URL(Url));
		}
		catch(IOException e){}
      	
      	image =  img;
      	
      	// An image is read from the url that is given as a parameter 
      	// There is a restriction for the images: Only 700x600 resolution 
      	
      	
      	this.teacherModeEnabled = teacherModeOn;
      	
      	JButton add = new JButton("Submit");
      	add.setActionCommand("AddDragAndDrop");
      	add.addActionListener(controller);
      	
      	JButton back = new JButton("Back");
      	back.addActionListener(controller);
      	add(back);

		addMouseListener(this);
		addMouseMotionListener(this);

		preview = new JButton( "Preview on/off");
		preview.setBackground( Color.RED);

		submit = new JButton("Submit");
		submit.addActionListener( new ButtonListener());

		but2 = new JButton("Show/Hide answers");
		but2.addActionListener( new ButtonListener());
		add( but2);
		but2.setVisible( false);

		JButton skip = new JButton("Skip");
		skip.addActionListener(controller);

		// The button that shows and hides the answers (toggle between states)
		// This button is for the study mode of our project
		// We will design and implement another button for Test Mode where the user 
		// will be able to see the answer only after submitting the test
		removeQuestion.addActionListener( new ButtonListener());
		preview.addActionListener( new ButtonListener());

		but = new JButton("Show/Hide answers");
		but.addActionListener( new ButtonListener());



		// The BROWSE panel is nested in the teachermode outer panel
		// and set invisible as soon as an image is uploaded

		if( teacherModeEnabled)
		{
//			upload = new uploadPanel();
//			this.add(upload);
			this.add(add);
			this.add( removeQuestion);
			this.add( preview);
		}

		if( !teacherModeEnabled)
		{
			this.add( but);
			add(skip);


		}




		// Properties of myPanel
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.LIGHT_GRAY);
		evaluate = false;



	}

	public void setUrl(String s)
	{
		try
		{
			img = ImageIO.read( new URL(s));
		}catch(IOException e){}

		this.image = img;
		repaint();

	}

	public void reset()
	{
		for(  int i=0; i < as.size(); i++)
		{
			as.get(i).setX(701);
			as.get(i).setY(50*i);

			repaint();
		}

	}


	public void answerControl()
	{
			for(int i = 0; i< as.size(); i++)
			{
				if(as.get(i).getX() == as.get(i).getaX() && as.get(i).getY() == as.get(i).getaY())
				{
					correct++;	
					qNo++;
				}
				else
				{
					wrong++;
					qNo++;

				}
			}

	}


	public void showAnswer(boolean b)
	{
		evaluate = b;
		repaint();
	}

	public void enableTeacherMode( )
	{
		this.teacherModeEnabled = true;
		repaint();


	}

	public void increaseSize()
	{
		this.setSize(900, 700);
		repaint();

	}
	public void originalSize()
	{
		this.setSize(800, 600);
		repaint();

	}

	// The method that adds questions into the panel
	public void addQuestion( int x, int y, String title) // x and y represent the location of the answer
	{
		int ind = this.as.size();
		Box tmp = new Box(701, 50*ind, 100, 50, new Point(x, y), title);
//		this.as.add( tmp);

		if(as.size()<=10)
			as.add(tmp);

//		if(teacherModeEnabled)
//		{
//			for(int f=0; f< as.size(); f++)
//			{
//				Box tmp1 = as.get(f);
//				for(int g=0; g<as.size(); g++)
//				{
//					if( g !=f)
//					{
//						Box tmp2 = as.get(g);
//						if( tmp1.contains(tmp2))
//							as.remove(tmp2);
//					}
//				}
//			}
//		}

	}



	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		// Draws the image
		g.drawImage( image, 0, 0, 700, 600, this);

		for(int i = 0; i< as.size(); i++)
		{
			if( i<=9)
				as.get(i).draw(g);
		}


		if(teacherModeEnabled)
		{
			for(int s = 0; s < as.size(); s++)
			{
				if( s<=9)
				{
					g.setFont( new Font("Arial", Font.BOLD, 13));
					g.drawString(" " + (s+1), 780, (50*(s+1))-3);
				}

			}


		}

		// Evaluates the answers so far
		if(evaluate)
		{
			for(int i = 0; i< as.size(); i++)
			{
				if(as.get(i).getX() == as.get(i).getaX() && as.get(i).getY() == as.get(i).getaY())
				{
					g.setColor(Color.GREEN);
					g.fillRect(as.get(i).getX(), as.get(i).getY(), as.get(i).w,as.get(i).h);

					g.setColor(Color.BLUE);
					g.setFont(new Font("Arial", Font.BOLD, 15));
					g.drawString(as.get(i).title,as.get(i).getX() + 15, as.get(i).getY() + 27);		
				}
				else
				{
					g.setColor(Color.RED);
					g.fillRect(as.get(i).getX(),as.get(i).getY(), as.get(i).w, as.get(i).h);

					g.setColor(Color.BLUE);
					g.setFont(new Font("Arial", Font.BOLD, 15));
					g.drawString(as.get(i).title,as.get(i).getX() + 15, as.get(i).getY() + 27);

				}
			}
		}



	}
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!teacherModeEnabled)
		{
			for(int i = 0; i< as.size();i++)
			{
				as.get(i).contains(e.getX(), e.getY());
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(!teacherModeEnabled)
		{//if 1
			Point c = e.getPoint();
			System.out.println( e.getX() + "," + e.getY());

			for( int i = 0; i< as.size(); i++)
			{//for 1
				// Scans the set of questions which is an (Arraylist<Box>) and only evaluates the boxes that are selected
				// Boxes are selected if and only if they are still capable of being dragged
				if(as.get(i).getSelected())
				{//if3
					Box b = as.get(i);

					// Planted variable holds the fact whether the box is dropped within an answer box
					boolean planted = false;
					int full = 0;
					int count = 0;


					for( int k = 0; k < as.size(); k++)
					{

							if (Math.abs(b.getX() - as.get(k).getaX()) < 100 && Math.abs(b.getY() - as.get(k).getaY()) < 50 ) 
							{



								b.setX(as.get(k).getaX());
								b.setY(as.get(k).getaY());
								planted = true;
								full = k;



							} 
							else if(Math.abs(b.getX() - as.get(k).getaX()) < 100 && Math.abs(b.getY() - as.get(k).getaY()) < 50 )
							{


									planted = true;
									b.setX(801);
									b.setY(50*i);

									as.get(k).setX(801);
									as.get(k).setY(50*k);
									 full = k;

							}
					 }



				 	// Checks whether there are more than one box at an answer location
				 	for( int m = 0; m< as.size(); m++)
					{
						if(as.get(m).contains( as.get(full).getaX(), as.get(full).getaY()))
						{
							count++;
						}
					}

					// Sends the box to the original position 
					if(!planted )
				 	{

				 		b.setX(701);
						b.setY(50*i);
				 	}

				 	// Sends the overlapping box to the original state
				 	if(count>1 )
				 	{

				 		b.setX(701);
						b.setY(50*i);
				 	}

				}//if3

			}//for1
			repaint();
		}// if 1
		else
		{

			boolean overlaps = false;

			for( int q=0; q<as.size(); q++)
			{
				if( Math.abs(e.getX() - as.get(q).getaX()) <= 100  && Math.abs(e.getY() - as.get(q).getaY()) <= 50 )
				{
					overlaps = true;
					JOptionPane.showMessageDialog( null, "Answers should not overlap!");
				}

			}


			if(e.getX()>695)
			{
				JOptionPane.showMessageDialog( null, "Please stay in the picture");
			}
			else if( !overlaps)
			{
				Point a = e.getPoint();

				ansTitle = JOptionPane.showInputDialog("What is the answer for this question?");

				if(ansTitle != null && !(ansTitle.equals("")))
				{
					addQuestion( (int) a.getX(), (int) a.getY(), ansTitle);
					repaint();	
				}

			}

		}
		repaint();

	}

	public void toggleEvaluate()
	{
		this.evaluate = !evaluate;
	}


	@Override
	public void mouseDragged(MouseEvent e) 
	{
		if(!teacherModeEnabled)
		{
			for(int i = 0; i<as.size(); i++)
			{
				Box b = as.get(i);

				if (b.getSelected())
				{

					// matches the center of the box to the mouse while dragging
					b.setX(e.getX() - 25);
					b.setY(e.getY() - 25);
					repaint();

				}


			}
		}

	}

	public void addButton( JButton b)
	{
		this.add(b);
		repaint();
	}

	public void removeButton( JButton b)
	{
		this.remove(b);
		repaint();
	}
	public void playWithSize()
	{
		this.setSize( new Dimension(850, 650));
		this.setSize( new Dimension(800, 600));
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public class ButtonListener implements ActionListener
	{
			public void actionPerformed(ActionEvent e)
			{
				JButton c = (JButton) e.getSource();

				if(c == submit)
				{
					answerControl();
					JOptionPane.showMessageDialog( null,  " " + correct + "/" + qNo + " correct answers");

				}

				if(c == but2)
				{
					toggleEvaluate();
					repaint();

					if(evaluate)
						but2.setBackground(Color.GREEN);
					else
						but2.setBackground(Color.RED);
				}

				if( c == but)
				{
					toggleEvaluate();
					repaint();
				}


				if( c == removeQuestion )
				{
					do
					{
						ok = true;
						numStr = JOptionPane.showInputDialog(" Which question would you like to remove (Enter number)");

						if( numStr != null && !(numStr.equals("")) )
						{
							num = Integer.parseInt( numStr);
							// Removes the question selected
							if( num <= as.size()  && num > 0)
							{
								JOptionPane.showMessageDialog( null, "Question " + num + " removed");
								as.remove(num-1);


								for(int i= num; i <= as.size(); i++)
								{	
									as.get(i-1).setY(50*(i-1));
									repaint();
								}
								ok = false;
							}
							// Shows a message explaining that the number entered is invalid
							else
							{
								again = JOptionPane.showConfirmDialog( null, "Number is invalid, Try again?", "Oops!", JOptionPane.YES_NO_OPTION );

							}

						}
						else
						{
							ok = false;
						} 			

					}while( again == JOptionPane.YES_OPTION && ok);

					repaint();		

				}
				if( c == preview)
				{
					teacherModeEnabled = !teacherModeEnabled;


					if(teacherModeEnabled)
					{
						but2.setVisible( false);
						removeQuestion.setVisible( true);
					}	
					else
					{
						removeQuestion.setVisible( false);
						but2.setVisible( true);
					}

					if(teacherModeEnabled)
					{
						preview.setBackground(Color.RED);
						reset();
					}
					if(!teacherModeEnabled)
					{
						preview.setBackground(Color.GREEN);
						reset();						
					}
//					increaseSize();
//					originalSize();

					repaint();

				}

			}
	}
}
