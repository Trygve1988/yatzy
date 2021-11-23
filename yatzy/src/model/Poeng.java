package model;

public class Poeng {
	String beskrivelse = "ass";
	String poeng = "";
    
	public Poeng(String beskrivelse, String poeng) {
		this.beskrivelse = beskrivelse;
		this.poeng = poeng;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public String getPoeng() {
		return poeng;
	}

}
