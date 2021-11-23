package view.paneler.centerPanel;

import javax.swing.*;

import fonts.Fonts;

@SuppressWarnings("serial")
public class HoldKnappPanel extends JPanel{
	private JToggleButton hold1Knapp = new JToggleButton("Hold1");
	private JToggleButton hold2Knapp = new JToggleButton("Hold2");
	private JToggleButton hold3Knapp = new JToggleButton("Hold3");
	private JToggleButton hold4Knapp = new JToggleButton("Hold4");
	private JToggleButton hold5Knapp = new JToggleButton("Hold5");
	
	public HoldKnappPanel() {
		hold1Knapp.setFont(Fonts.getBoldFont1());
		hold2Knapp.setFont(Fonts.getBoldFont1());
		hold3Knapp.setFont(Fonts.getBoldFont1());
		hold4Knapp.setFont(Fonts.getBoldFont1());
		hold5Knapp.setFont(Fonts.getBoldFont1());
		add(hold1Knapp);
		add(hold2Knapp);
		add(hold3Knapp);
		add(hold4Knapp);
		add(hold5Knapp);
	}

	public JToggleButton getHold1Knapp() {
		return hold1Knapp;
	}

	public JToggleButton getHold2Knapp() {
		return hold2Knapp;
	}

	public JToggleButton getHold3Knapp() {
		return hold3Knapp;
	}

	public JToggleButton getHold4Knapp() {
		return hold4Knapp;
	}

	public JToggleButton getHold5Knapp() {
		return hold5Knapp;
	}

	public void nullstill() {
		hold1Knapp.setSelected(false);
		hold2Knapp.setSelected(false);
		hold3Knapp.setSelected(false);
		hold4Knapp.setSelected(false);
		hold5Knapp.setSelected(false);
	}
	
	public void disable() {
		hold1Knapp.setEnabled(false);
		hold2Knapp.setEnabled(false);
		hold3Knapp.setEnabled(false);
		hold4Knapp.setEnabled(false);
		hold5Knapp.setEnabled(false);
	}
	
	public void enable() {
		hold1Knapp.setEnabled(true);
		hold2Knapp.setEnabled(true);
		hold3Knapp.setEnabled(true);
		hold4Knapp.setEnabled(true);
		hold5Knapp.setEnabled(true);
	}

}
