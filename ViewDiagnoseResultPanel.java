import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChartDirector.ChartViewer;
import ChartDirector.PolarChart;

public class ViewDiagnoseResultPanel extends JPanel {

	Controller controller;

	ChartViewer viewer;
	public ViewDiagnoseResultPanel( Controller controller) {
		this.controller = controller;

		setBackground(new Color(240, 255, 255));
		setPreferredSize(new Dimension(800, 600));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout());

		viewer = new ChartViewer();

		JPanel bottom = new JPanel();
		JButton b = new JButton("Back");
		b.setActionCommand("BackToCategoryPanel");
		b.addActionListener(controller);
        bottom.add(b);
        
        add( bottom,  BorderLayout.SOUTH);    
		add( viewer, BorderLayout.NORTH);

	}

	public void createChart(int a , int b, int ca, int d, int e)
    {
		a = a * 10;
		b = b * 10;
		ca = ca * 10;
		d = d * 10;
		e = e * 10;
		if(a == 100 && b == 100 &&ca == 100 &&d == 100 &&e == 100 ){
			a = 99;
		}
        // The data for the chart
        double[] data = {a, b, ca, d, e};

        // The labels for the chart
        String[] labels = {"Present Simple Tense", "Present Perfect Tense", "Past Simple Tense", "Past Perfect Tense", "Future Tense"}
            ;

        // Create a PolarChart object of size 450 x 350 pixels
        PolarChart c = new PolarChart(700,500);

        // Set center of plot area at (225, 185) with radius 150 pixels
        c.setPlotArea(350, 230, 200);
        
        // Add an area layer to the polar chart
        c.addAreaLayer(data, 0x9999ff);

        // Set the labels to the angular axis as spokes
        c.angularAxis().setLabels(labels);

        // Output the chart
        viewer.setChart(c);

        //include tool tip for the chart
        viewer.setImageMap(c.getHTMLImageMap("clickable", "",
            "title='{label}: score = {value}'"));
        
    }
}
