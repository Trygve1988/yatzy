package view.paneler.startPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import fonts.Fonts;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	JLabel label = new JLabel("Velg antall Spillere", SwingConstants.CENTER);
	JSlider jSlider = new JSlider(JSlider.HORIZONTAL,1, 4, 2);
	JButton startKnapp = new JButton("Start");

	public StartPanel() {
		label.setFont(Fonts.getBoldFont1());
		startKnapp.setFont(Fonts.getBoldFont1());
		jSlider.setMajorTickSpacing(1);
		jSlider.setMinorTickSpacing(1);
		jSlider.setPaintTicks(true);
		jSlider.setPaintLabels(true);
    	setLayout(new BorderLayout());
    	add(label, BorderLayout.NORTH);
    	add(jSlider, BorderLayout.CENTER);
    	add(startKnapp, BorderLayout.SOUTH);
    	setBorder(new EmptyBorder(150, 100, 150, 100));
	}

	public int getAntallSpillere() {
		return jSlider.getValue();
	}

	public JButton getStartKnapp() {
		return startKnapp;
	}
	
	

}
