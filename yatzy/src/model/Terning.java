package model;

public class Terning {
	int �yne = 0;
	boolean spare = false;
	
	public int get�yne() {
		return �yne;
	}
	
	public int kast() {
		if (!spare) {
			�yne = (int)(Math.random()*6)+1;	
		}
		return �yne;
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
