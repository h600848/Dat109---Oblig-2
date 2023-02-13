package no.hvl.dat109;

public class main {

	public static void main(String[] args) {
		Bil bil1 = new Bil("XX12345", "Audi", "R8", "Rød", UtleierGruppe.STOR);
		Bil bil2 = new Bil("XY12345", "BMW", "I8", "Blå", UtleierGruppe.MEDIUM);
		Bil bil3 = new Bil("XZ12345", "Polestar", "NordPol", "Hvit", UtleierGruppe.STOR);
		
		UtleieFirma utleiefirma = new UtleieFirma("SuperBilLeie","Slotsgaten 1","22225555");
		
		UtleieKontor utleiekontor = new UtleieKontor("1", "Bakgaten 37", "22225566", utleiefirma);
		
		utleiekontor.leggTilBil(bil1);
		utleiekontor.leggTilBil(bil2);
		utleiekontor.leggTilBil(bil3);
		
		utleiekontor.logginn();
	}

}
