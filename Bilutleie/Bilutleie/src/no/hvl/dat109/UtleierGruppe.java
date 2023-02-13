package no.hvl.dat109;

public enum UtleierGruppe {

	LITEN(1000),
	MEDIUM(2000),
	STOR(3000),
	STASJONSVOGN(3500);
	
	
	private int pris;
	
	UtleierGruppe(int pris) {
		this.pris = pris;
	}
	
	public int getPris() {
		return pris;
	}
}
