package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtleieKontor {
	
	private String kontorNum, adresse, telefonNum;
	private List<Bil> ledigeBiler;
	List<Kunde> kunder = new ArrayList<>();
	private UtleieFirma firma;
	
	public UtleieKontor(String kontorNum, String adresse, String telefonNum, UtleieFirma firma) {
		super();
		this.kontorNum = kontorNum;
		this.adresse = adresse;
		this.telefonNum = telefonNum;
		this.ledigeBiler = new ArrayList<Bil>();
		this.firma = firma;
	}
	
	public Boolean leggTilBil(Bil bil) {
		if(ledigeBiler.add(bil)) {
			return true;
		}
		return false;
	}
	
	private Boolean fjernBil(String regNum) {
		if(ledigeBiler.removeIf(b -> b.getRegNum() == regNum)) {
			return true;
		}
		return false;
	}
	
	
	public Kunde registrerKunde(Scanner scanner) {

		System.out.println("Skriv inn fornavn: ");
		String fornavn = scanner.next();
		
		System.out.println("Skriv inn etternavn: ");
		String etternavn = scanner.next();
		
		System.out.println("Skriv inn telefonnummer: ");
		String telefonnummer = scanner.next();
		
		System.out.println("Skriv inn adresse: ");
		String adresse = scanner.next();
		

		
		Kunde kunde = new Kunde(fornavn, etternavn, telefonnummer, adresse);
		kunder.add(kunde);
		return kunde; 
	}
	
	public void logginn() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Skriv 1 for å logge inn, skriv 2 for å registrere bruker: ");
			int innlogg = scanner.nextInt();

			if (innlogg == 1 || innlogg == 2) {
				if (innlogg == 1) {
					System.out.println("Skriv inn telefonnummer for å logge inn.");
					String telefonnummer = scanner.nextLine();

					if (kunder.stream().filter(k -> k.getTelefonNum().equals(telefonnummer)).findFirst().isPresent()) {
						innlogget((kunder.stream().filter(k -> k.getTelefonNum().equals(telefonnummer)).findFirst()
								.get()), scanner);
					}
				}

				if (innlogg == 2) {
					Kunde kunde = registrerKunde(scanner);

					if (kunde != null) {
						innlogget(kunde, scanner);
					}
				} else {
					System.out.println("Skriv inn riktig nummer!");
				}
			}
		}
	}
  	
	public Boolean leiBil(Kunde kunde, String regNum) {
        Bil bil = finnBil(regNum);
        if(bil != null && bil.getLeidAv() == null) {
            bil.setLeidAv(kunde);
            //fjernBil(bil.getRegNum());
            return true;
        }
        else {
            System.out.println("Feil med leie av bil");
            return false;
        }
    }
	
	public Bil finnBil(String regNr) {
		for (Bil bil : ledigeBiler) {
			if (regNr.equals(bil.getRegNum()))
				return bil;
		}
		return null;
	}
	
	public void printLedigBil() {
        ledigeBiler.stream().filter(b -> b.getLeidAv() == null).forEach(System.out::println);
    }
	
	public void leverBil(String regNum, Kunde kunde) {
		Bil bil = finnBil(regNum);
		if (bil != null) {
			if (kunde == bil.getLeidAv()) {
				bil.setLeidAv(null);
				//leggTilBil(bil);
				System.out.println(
						"Bilen: " + bil.toString() + " er nå levert og prisen ble: " + bil.getBilGruppe().getPris());
			} else
				System.err.println("Finner ikke bil registrert til deg med dette registererings nummeret.");
		} else
			System.err.println("Finner ikke bil med dette registerings nummeret.");
	}
	
	private void innlogget(Kunde kunde, Scanner scanner) {
		
		int out = 0;
		while (out != 4) {
			System.out.println("Skriv 1 for å leie bil.");
			System.out.println("Skriv 2 for å se ledige biler");
			System.out.println("Skriv 3 for å levere fra seg en bil");
			System.out.println("Skriv 4 for å logge av");
			out = scanner.nextInt();

			switch (out) {
			case 1: {
				System.out.println("Skriv regNr på bilen du ønsker å leie.");
				String regNr = scanner.next();
				leiBil(kunde, regNr);
				System.out.println("Takk for at du valgte å leie hos " + firma.getFirmaNavn());
				break;
			}

			case 2: {
				System.out.println("");
				printLedigBil();
				break;
			}
			
			case 3: {
				System.out.println("Skriv regNr på bilen du ønsker å levere fra deg: ");
				String regNr = scanner.next();
				leverBil(regNr, kunde);
			
				break;
			}
			
			case 4: {
				out = 4;
				break;
			}
			
			}

		}

	}
	
	public Boolean erBilOpptatt(Bil bil) {
		if(bil.getLeidAv() != null) {
			return true;
		}
		return false;
	}
	

	public String getKontorNum() {
		return kontorNum;
	}

	public void setKontorNum(String kontorNum) {
		this.kontorNum = kontorNum;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelefonNum() {
		return telefonNum;
	}

	public void setTelefonNum(String telefonNum) {
		this.telefonNum = telefonNum;
	}

	public List<Bil> getLedigeBiler() {
		return ledigeBiler;
	}

	public void setLedigeBiler(List<Bil> ledigeBiler) {
		this.ledigeBiler = ledigeBiler;
	}

	public UtleieFirma getFirma() {
		return firma;
	}

	public void setFirma(UtleieFirma firma) {
		this.firma = firma;
	}
	
	
}
