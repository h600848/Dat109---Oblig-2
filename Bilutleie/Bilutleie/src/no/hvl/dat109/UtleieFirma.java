package no.hvl.dat109;

public class UtleieFirma {

	private String firmaNavn, adresse, telefonNum;

	
	public UtleieFirma(String firmaNavn, String adresse, String telefonNum) {
		super();
		this.firmaNavn = firmaNavn;
		this.adresse = adresse;
		this.telefonNum = telefonNum;
	}


	public String getFirmaNavn() {
		return firmaNavn;
	}


	public void setFirmaNavn(String firmaNavn) {
		this.firmaNavn = firmaNavn;
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
	
	
}
