package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Haand {
	int antKast = 0;
	ArrayList<Terning> terninger = new 	ArrayList<>();
	boolean poengRegistrert = false;
	
	public Haand() {
		for (int i=0; i<5; i++) {
			terninger.add(new Terning());
		}	
	}

	public int getAntKast() {
		return antKast;
	}
	
	public void setAntKast(int antKast) {
		this.antKast = antKast;
	}

	public ArrayList<Terning> getTerninger() {
		return terninger;
	}

	public boolean isPoengRegistrert() {
		return poengRegistrert;
	}

	public void setPoengRegistrert() {
		this.poengRegistrert = true;
	}
	
	// 1) kast
	public ArrayList<Terning> kast() {
		if (antKast<3) {
			for (int i=0; i<terninger.size(); i++) {
				terninger.get(i).kast();
			}
			antKast++;
		}
		return terninger;
	}
	
	// 2) hold
	public void hold(int nr) {
		terninger.get(nr-1).hold();
	}
	
	// 3) getPoeng- metoder
	public int getPoengLike(int ¯yne) { 
		int poeng = 0;
		for (Terning t: terninger) {
			if (t.getÿyne() == ¯yne) {
				poeng += t.getÿyne();
			}
		}
		return poeng;
	}

	// getPoengGittAntallLike
	public int getPoengGittAntallLike(int kravAntall) {
		boolean funnet = false;
		int sjekkTall = 6;
		
		while (!funnet && sjekkTall>0) {
			//har vi par i 6ere?
			if (erMangeNok(kravAntall,sjekkTall)) {
				funnet = true;
			}
			else {
				sjekkTall--;
			}
		}
		int poeng = sjekkTall * kravAntall;
		//har vi yatzy?
		if (funnet && kravAntall==5) {
			poeng = 50;
		}
		return poeng;
	}
	
	public boolean erMangeNok(int kravAntall, int sjekkTall) {
		int antallTreff = 0;
		for (Terning t: terninger) {
			if (t.getÿyne() == sjekkTall) {
				antallTreff++;
			}
		}
		//mange nok?
		if (antallTreff>=kravAntall) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	// getPoeng2Par
	public int getPoeng2Par() {
		int poeng = 0;
		int kravAntall = 2;
		int antPar = 0;
		int sjekkTall = 6;
		while (antPar<2 && sjekkTall>0) {
			//har vi par i 6ere?
			if (erMangeNok(kravAntall,sjekkTall)) {
				antPar++;
				poeng += sjekkTall * kravAntall;
				sjekkTall--;
			}
			else {
				sjekkTall--;
			}
		}
		//har vi 2 par?
		if (antPar<2) {
			poeng = 0;
		}
		return poeng;
	}
	
	// getPoengHus
	public int getPoengHus() {
		int poeng = 0;
		//finner 3 like
		boolean funnetTreLike = false;
		int sjekkTall = 6;
		int treLikeTall = 0;
		while (!funnetTreLike && sjekkTall>0) {
			if (erMangeNok(3,sjekkTall)) {
				funnetTreLike = true;
				treLikeTall = sjekkTall;
			}
			else {
				sjekkTall--;
			}
		}
		//finner 2 like. kan ikke vÊre samme tall som treLikeTall
		boolean funnetToLike = false;
		sjekkTall = 6;
		while (!funnetToLike && sjekkTall>0) {
			if (sjekkTall==treLikeTall) {
				sjekkTall--;
			}
			else if (erMangeNok(2,sjekkTall)) {
				funnetToLike = true;
			}
			else {
				sjekkTall--;
			}
		}
		if (funnetTreLike && funnetToLike) {
			poeng = getPoengTellOppÿyne();
		}
		return poeng;
	}
	
	// getPoengSjanse
	public int getPoengTellOppÿyne() {
		int poeng = 0;
		for (Terning t: terninger) {
			poeng += t.getÿyne();
		}
		return poeng;
	}
	
	// getPoengLitenStraight
	public int getPoengLitenStraight() {
		int poeng = 0;
		int [] sortert = new int[terninger.size()];
		for (int i=0; i<sortert.length; i++) {
			sortert[i] += terninger.get(i).getÿyne();
		}
		Arrays.sort(sortert);
		if (erLitenStraight(sortert)) {
			poeng = 15;
		}
		return poeng;
	}
	
	public boolean erLitenStraight(int [] sortert) {
		boolean erLitenStraight = true;
		for (int i=0; i<sortert.length; i++) {
			if (sortert[i] != (i+1)) {
				erLitenStraight = false;
			}
		}
		return erLitenStraight;	
	}
	
	// getPoengStorStraight
	public int getPoengStorStraight() {
		int poeng = 0;
		int [] sortert = new int[terninger.size()];
		for (int i=0; i<sortert.length; i++) {
			sortert[i] += terninger.get(i).getÿyne();
		}
		Arrays.sort(sortert);
		if (erStorStraight(sortert)) {
			poeng = 20;
		}
		return poeng;
	}
	
	public boolean erStorStraight(int [] sortert) {
		boolean erStorStraight = true;
		for (int i=0; i<sortert.length; i++) {
			if (sortert[i] != (i+2)) {
				erStorStraight = false;
			}
		}
		return erStorStraight;	
	}
}