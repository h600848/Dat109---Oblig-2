package no.hvl.dat109;

public class Bil {
	private String regNum, merke, modell, farge;
	private UtleierGruppe bilGruppe;
	private Kunde leidAv;
		
	public Bil(String regNum, String merke, String modell, String farge, UtleierGruppe bilGruppe) {
		this.regNum = regNum;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.bilGruppe = bilGruppe;
		this.leidAv = null;
	}
	
	public Kunde getLeidAv() {
		return leidAv;
	}

	public void setLeidAv(Kunde leidAv) {
		this.leidAv = leidAv;
	}




	public String getRegNum() {
		return regNum;
	}


	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}


	public String getMerke() {
		return merke;
	}


	public void setMerke(String merke) {
		this.merke = merke;
	}


	public String getModell() {
		return modell;
	}


	public void setModell(String modell) {
		this.modell = modell;
	}


	public String getFarge() {
		return farge;
	}


	public void setFarge(String farge) {
		this.farge = farge;
	}


	public UtleierGruppe getBilGruppe() {
		return bilGruppe;
	}


	public void setBilGruppe(UtleierGruppe bilGruppe) {
		this.bilGruppe = bilGruppe;
	}

	@Override
	public String toString() {
		return "Bil [regNum=" + regNum + ", merke=" + merke + ", modell=" + modell + ", farge=" + farge + ", bilGruppe="
				+ bilGruppe + ", leidAv=" + leidAv + "]";
	}
	
	
	
}
