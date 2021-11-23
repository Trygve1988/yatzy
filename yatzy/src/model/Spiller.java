package model;

import java.util.ArrayList;

public class Spiller {
	int antTurer = 1;
	Haand haand = new Haand();
	int [] poengTab = new int [18];
	boolean sumRegistrert = false;
	
	public int getAntTurer() {
		return antTurer;
	}

	public Haand getHaand() {
		return haand;
	}
	
	public int [] getPoengTab() {
		return poengTab;
	}
	
	// 1) kast
	public ArrayList<Terning> kast() {
		if (haand.antKast==3) {
			nesteTur();
		}
		return haand.kast();
	}
	
	public void nesteTur() {
		if (antTurer>=15) {
			System.out.println("ingen flere turer!");
		}
		else if (!haand.isPoengRegistrert()) {
			System.out.println("Venligst registrer poeng først");
		}
		else {
			haand = new Haand();
			antTurer++;
		}
	}
	
	// 2) hold
	public void hold(int i) {
		haand.hold(i);
	}
	
	// 3) registrerPoeng
	public boolean erPoengPosLedig(int poengPos) {
		boolean erPoengPosLedig = true;
		if (poengPos == 6 || poengPos == 7 || poengPos == 17) {
			erPoengPosLedig = false;
		}
		else if (poengTab[poengPos] != 0) {
			erPoengPosLedig = false;
		}
		return erPoengPosLedig;	
	}
	
	public void registrerPoeng(int tall) {
		if (!haand.isPoengRegistrert()) {
			int poeng = 0;
			switch (tall) {
				case 0: 	poeng = haand.getPoengLike(tall+1);			break;
				case 1: 	poeng = haand.getPoengLike(tall+1);			break;
				case 2: 	poeng = haand.getPoengLike(tall+1);			break;
				case 3: 	poeng = haand.getPoengLike(tall+1);			break;
				case 4: 	poeng = haand.getPoengLike(tall+1);			break;
				case 5: 	poeng = haand.getPoengLike(tall+1);			break;
				case 6: 	break;
				case 7: 	break;
				case 8: 	poeng = haand.getPoengGittAntallLike(2);	break;
				case 9: 	poeng = haand.getPoeng2Par();				break;
				case 10: 	poeng = haand.getPoengGittAntallLike(3);	break;
				case 11: 	poeng = haand.getPoengGittAntallLike(4);	break;
				case 12: 	poeng = haand.getPoengLitenStraight();		break;
				case 13:	poeng = haand.getPoengStorStraight();		break;
				case 14: 	poeng = haand.getPoengHus();				break;
				case 15: 	poeng = haand.getPoengTellOppØyne();		break;
				case 16:	poeng = haand.getPoengGittAntallLike(5);	break;
				case 17: System.out.println("Totalsum");	
			}
			// viss 0 poeng registrerer vi -1 for å markere at denne posisjonen er opptatt
			if (poeng == 0) {
				poengTab[tall] = -1;
			}
			else {
				poengTab[tall] = poeng;
			}
			haand.setPoengRegistrert();
			haand.setAntKast(3);
			sumSjekk();
			poengTab[poengTab.length-1] = getTotalsum();
		}
	}
		
	public void sumSjekk() {	
		if (!sumRegistrert) {
			boolean fyltAlleFelt = true;
			for (int i=0; i<6; i++)	{
				if (poengTab[i]==0) {
					fyltAlleFelt = false;
				}
			}
			if (fyltAlleFelt) {
				int poeng = 0;
				for (int i=0; i<6; i++)	{
					if (poengTab[i]>0) {
						poeng += poengTab[i];
					}
				}
				poengTab[6] = poeng; //sum
				if (poeng>62) {
					poengTab[7] = 50; //bonus	
				}
			}
		}	
	}
	
	public int getTotalsum() {	
		int poeng = 0;
		for (int i=0; i<poengTab.length-1; i++)	{
			if (poengTab[i]>0 ) {	//|| 
				if (i != 6 ) {
					poeng += poengTab[i];
				}
			}
		}
		return poeng;
	}
}
