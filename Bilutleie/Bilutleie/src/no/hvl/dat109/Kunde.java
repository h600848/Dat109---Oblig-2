package no.hvl.dat109;

public class Kunde {

	private String fornavn;
	private String etternavn;
	private String telefonNum;
	private String adresse;
	
	public Kunde(String fornavn, String etternavn, String telefonNum, String adresse) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.telefonNum = telefonNum;
		this.adresse = adresse;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getTelefonNum() {
		return telefonNum;
	}

	public void setTelefonNum(String telefonNum) {
		this.telefonNum = telefonNum;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
}
