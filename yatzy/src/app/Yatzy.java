package app;

import fonts.Fonts;
import model.*;
import view.paneler.blokk.Blokk;
import view.paneler.centerPanel.CenterPanel;
import view.paneler.startPanel.StartPanel;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Yatzy {
	static int spillerTur = 0;
	static ArrayList<Spiller> spillere = new ArrayList<>();
	static StartPanel startPanel = new StartPanel();
	static Blokk blokk = new Blokk();
	static CenterPanel centerPanel = new CenterPanel();
	static JButton kastKnapp = new JButton("Kast");
	static JPanel hovedPanel = new JPanel();
	static JFrame jFrame = new JFrame();
	
    public static void main(String[] args) throws Exception {
    	System.out.println("Viktig melding!");
    	System.out.println("Viktig melding2!");
    	System.out.println("Viktig melding2!");
    	
    	//jpanel
    	kastKnapp.setFont(Fonts.getBoldFont1());
    	hovedPanel.setLayout(new BorderLayout());
    	hovedPanel.add(startPanel, BorderLayout.CENTER);
    	
    	// 2) action
    	startPanel.getStartKnapp().addActionListener(e -> startSpill());
    	kastKnapp.addActionListener(e -> kast());
    	centerPanel.getHoldKnappPanel().getHold1Knapp().addActionListener(e -> hold(1));
    	centerPanel.getHoldKnappPanel().getHold2Knapp().addActionListener(e -> hold(2));
    	centerPanel.getHoldKnappPanel().getHold3Knapp().addActionListener(e -> hold(3));
    	centerPanel.getHoldKnappPanel().getHold4Knapp().addActionListener(e -> hold(4));
    	centerPanel.getHoldKnappPanel().getHold5Knapp().addActionListener(e -> hold(5));
    	blokk.getTabell().addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int rad = blokk.getTabell().rowAtPoint(evt.getPoint());
		        if (rad >= 0) {
		        	registrerPoeng(rad);
		        }
		    }
		});
	 
    	// jFrame
    	jFrame.add(hovedPanel);
    	jFrame.setSize(500, 650);
    	jFrame.setVisible(true);
    }
    
    // 0) startSpill
    public static void startSpill()  {
    	int antSpillere = startPanel.getAntallSpillere();
    	for (int i=0; i<antSpillere; i++) {
    		spillere.add(new Spiller());
    	}
    	hovedPanel.removeAll();
    	hovedPanel.add(blokk, BorderLayout.NORTH);
    	hovedPanel.add(centerPanel, BorderLayout.CENTER);
    	hovedPanel.add(kastKnapp, BorderLayout.SOUTH);
    	kast();
    	SwingUtilities.updateComponentTreeUI(jFrame);
    }
    
    // 1) kast
    public static void kast()  {
    	try {
    	    ArrayList<Terning> terninger = spillere.get(spillerTur).kast();
    	    centerPanel.getTerningPanel().oppdater(terninger);
    	    //aktiverer hold knappene
    	    centerPanel.getHoldKnappPanel().setEnabled(true);
    	    //status
    	    centerPanel.getStatusLabel().setText("spiller nr " + (spillerTur+1) + " - Tur nr " + spillere.get(spillerTur).getAntTurer() + " - Kast nr " + spillere.get(spillerTur).getHaand().getAntKast());
    	    //deaktiverer kast knappen viss spiller har kastet 3 ganger
    	    if (spillere.get(spillerTur).getHaand().getAntKast()==3) {
    	       kastKnapp.setEnabled(false);
    	    }
    	    SwingUtilities.updateComponentTreeUI(jFrame);
    	}
    	catch (Exception e) {
    		System.out.println("Feil!");
    	}
    }
    
    // 2) hold
    public static void hold(int i) {
    	System.out.println("hold " + i);
    	spillere.get(spillerTur).hold(i);
    }
    
    // 3) registrerPoeng
    public static void registrerPoeng(int poengPos) {
    	Spiller spiller = spillere.get(spillerTur);
    	if (!spiller.erPoengPosLedig(poengPos)) {
    		System.out.println("Ulovelig trekk");
    	}
    	else {
	    	//registrer Poeng
    		spiller.registrerPoeng(poengPos);
	    	int [] poengtab = spiller.getPoengTab();
	    	blokk.oppdater(spillerTur,poengtab);
		    //nullstiller og deaktiverer hold knappene
		    centerPanel.getHoldKnappPanel().nullstill();
	    	centerPanel.getHoldKnappPanel().setEnabled(false);
		    // viss spill ikke er ferdig
		    if (!erSpillFerdig()) {
		       	//status
		    	centerPanel.getStatusLabel().setText("spiller nr " + (spillerTur+1) + " - Tur nr " + spillere.get(spillerTur).getAntTurer() + " - Kast nr " + spillere.get(spillerTur).getHaand().getAntKast() + " - Poeng registrert");	
			    //aktiverer kast knappen 
			    kastKnapp.setEnabled(true);
			    // neste spillerTur
			    spillerTur++;
			    if (spillerTur >= spillere.size()) {
			    	spillerTur = 0;
			    }
			    kast();
		    }
		    SwingUtilities.updateComponentTreeUI(jFrame);
	    }
    }

	private static boolean erSpillFerdig() {
		boolean erSpillFerdig = false;
		if (spillerTur==spillere.size()-1 && spillere.get(spillerTur).getAntTurer()>=15) {
		    kastKnapp.setEnabled(false);
			//finner spiller med høyest poengsum
			int vinner = 0;
			int hoyestPoengSum = 0;
    	    for (int i=0; i<spillere.size(); i++) {
    	    	int sjekkPoengSum = spillere.get(i).getTotalsum();
    	    	if (sjekkPoengSum>hoyestPoengSum) {
    	    		hoyestPoengSum = sjekkPoengSum;
    	    		vinner = i+1;
    	    	}
     	    }
			centerPanel.getStatusLabel().setText("Gratulerer spiller nr " + vinner + ". Du vandt med " + hoyestPoengSum + " poeng");	
			erSpillFerdig = true;
		}  	
		return erSpillFerdig;
	}
}
//System.out.println();