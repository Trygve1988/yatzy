package model;

public class Terning {
	int øyne = 0;
	boolean spare = false;
	
	public int getØyne() {
		return øyne;
	}
	
	public int kast() {
		if (!spare) {
			øyne = (int)(Math.random()*6)+1;	
		}
		return øyne;
	}

	public void hold() {
		if (spare) {
			spare = false;
		}
		else {
			spare = true;
		}
	}
}
