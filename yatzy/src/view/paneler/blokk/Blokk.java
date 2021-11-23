package view.paneler.blokk;

import javax.swing.*;

import fonts.Fonts;

@SuppressWarnings("serial")
public class Blokk extends JScrollPane {
	String[] beskrivelseTab = {"Enere","Toere","Treere","Firere","Femere","Seksere","Sum","Bonus","1 par",
	    		"2 par","3 like","4 like","Liten straight","Stor straight","Hus","Sjanse","Yatzy","Totalsum"};
	String[][] data = new String[beskrivelseTab.length][beskrivelseTab.length];
	String[] columnNames = { "Kategori","p1","p2","p3","p4"};
	JTable tabell = new JTable(data, columnNames);
	
	public Blokk() {
		tabell.setDefaultEditor(Object.class, null);
	    for (int i=0; i<beskrivelseTab.length; i++) {
	    	data[i][0] = ""+beskrivelseTab[i];
	    }
		getViewport().add(tabell);
		tabell.setFont(Fonts.getPlainFont1());
		setSize(10,10);
	}

	public JTable getTabell() {
		return tabell;
	}
	
	public void oppdater(int spillerTur, int[] poengTab) {
	    for (int i=0; i<beskrivelseTab.length; i++) {
	    	data[i][0] = ""+beskrivelseTab[i];
	    }
	    for (int i=0; i<beskrivelseTab.length; i++) {
	    	String poeng = ""+poengTab[i];
	    	if (poeng.equals("0")) {
	    		poeng = " ";
	    	}
	    	else if (poeng.equals("-1")) {
	    		poeng = "-";
	    	}
	    	data[i][spillerTur+1] = ""+poeng;
	    }
	}

}
