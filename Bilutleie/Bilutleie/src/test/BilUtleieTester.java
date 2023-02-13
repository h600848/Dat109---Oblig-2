package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import no.hvl.dat109.*;


public class BilUtleieTester {

	private Kunde kunde1;
	private Kunde kunde2;
	private UtleieFirma utleieFirma;
	private UtleieKontor kontor;
	
	Bil bil1 = new Bil("XX12345", "Audi", "R8", "Rød", UtleierGruppe.STOR);
	Bil bil2 = new Bil("XY12345", "BMW", "I8", "Blå", UtleierGruppe.MEDIUM);
	Bil bil3 = new Bil("XZ12345", "Polestar", "NordPol", "Hvit", UtleierGruppe.STOR);
	
	@BeforeEach
	void prep() {
		kunde1 = new Kunde("Mikkel", "Bond", "12345678", "Heimdal 21");
		kunde2 = new Kunde("Pål", "Roger", "87654321", "Oppdal 41");
		utleieFirma = new UtleieFirma("TestFirma", "TestVeien 1", "00000000");
		kontor = new UtleieKontor("1", "Flyplass 1", "24681012", utleieFirma);
		kontor.leggTilBil(bil1);
		kontor.leggTilBil(bil2);
	}
	
	@Test
	void testLeggTilBil() {
		kontor.leggTilBil(bil3);
		assertEquals(bil3, kontor.finnBil(bil3.getRegNum()));
	}
	
	@Test
	void testFinnBil() {
		Bil tempBil = kontor.finnBil("XX12345");
		assertTrue(tempBil != null);
		tempBil = kontor.finnBil("Ikke gyldig regNum");
		assertTrue(tempBil == null);
	}
	
	@Test
	void testLeiBilogLeverBil() {
		Bil tempBil = kontor.finnBil("XX12345");
		kontor.leiBil(kunde1, tempBil.getRegNum());
		assertTrue(tempBil.getLeidAv() == kunde1);
		assertTrue(kontor.erBilOpptatt(tempBil));
		kontor.leverBil("XX12345", kunde1);
		assertTrue(tempBil.getLeidAv() == null);
		assertFalse(kontor.erBilOpptatt(tempBil));
	}
	
	@Test
	void testPrintAlleBiler() {
		kontor.printLedigBil();
	}
	
	
}
