package net.javaguides.springboot.springsecurity.web.dto;

public class ModifierEtatChauffDto {
	private int idComm;
	private int idEtat;
	private String date;

	public int getIdComm() {
		return idComm;
	}

	public void setIdComm(int idComm) {
		this.idComm = idComm;
	}

	public int getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(int idEtat) {
		this.idEtat = idEtat;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
