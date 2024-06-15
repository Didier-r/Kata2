package io.keepcoding.clas;

public class Equipo {
	private String nameEquipo;
	private int puntuacionEquipos;
	
	public Equipo(String nameEquipo,int puntuacionEquipos) {
		this.nameEquipo = nameEquipo;
		this.puntuacionEquipos = puntuacionEquipos;
	}

	public int getPuntuacionEquipos() {
		return puntuacionEquipos;
	}

	public void setPuntuacionEquipos(int puntuacionEquipos) {
		this.puntuacionEquipos = puntuacionEquipos;
	}

	public String getNameEquipo() {
		return nameEquipo;
	}

	public void setNameEquipo(String nameEquipo) {
		this.nameEquipo = nameEquipo;
	}
	public void incrementarPuntuacion() {
        this.puntuacionEquipos++;
    }

}
