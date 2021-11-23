package view.paneler.centerPanel;

import fonts.Fonts;
import model.Terning;

import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TerningPanel extends JPanel {

	public TerningPanel() {
		setLayout(new FlowLayout(0,55,0));
	}
	
	public void oppdater(ArrayList<Terning> terninger) throws Exception {
		removeAll();
		for (int i=0; i<terninger.size(); i++) {
    		//TerningGrafikk terningGrafikk = new TerningGrafikk(terninger.get(i).get�yne()); 
    		//add(terningGrafikk);
			Label label = new Label(""+terninger.get(i).get�yne());
			label.setFont(Fonts.getTerningFont());
			add(label);
		}
	}
	
}
