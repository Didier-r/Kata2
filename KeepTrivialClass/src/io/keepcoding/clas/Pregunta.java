package io.keepcoding.clas;

public class Pregunta {
private String tituloPregunta;
private String opcion1;
private String opcion2;
private String opcion3;
private String opcion4;
private int respuestaCorrecta;
public Pregunta(String tituloPregunta,String opcion1,String opcion2,String opcion3,String opcion4,int respuestaCorrecta) {
	this.tituloPregunta = tituloPregunta;
	this.opcion1 = opcion1;
	this.opcion2 = opcion2;
	this.opcion3 = opcion3;
	this.opcion4 = opcion4;
	this.respuestaCorrecta = respuestaCorrecta;
	
}
public int getRespuestaCorrecta() {
	return respuestaCorrecta;
}
public void setRespuestaCorrecta(int respuestaCorrecta) {
	this.respuestaCorrecta = respuestaCorrecta;
}
public String getTituloPregunta() {
	return tituloPregunta;
}
public void setTituloPregunta(String tituloPregunta) {
	this.tituloPregunta = tituloPregunta;
}
public String getOpcion1() {
	return opcion1;
}
public void setOpcion1(String opcion1) {
	this.opcion1 = opcion1;
}
public String getOpcion2() {
	return opcion2;
}
public void setOpcion2(String opcion2) {
	this.opcion2 = opcion2;
}
public String getOpcion3() {
	return opcion3;
}
public void setOpcion3(String opcion3) {
	this.opcion3 = opcion3;
}
public String getOpcion4() {
	return opcion4;
}
public void setOpcion4(String opcion4) {
	this.opcion4 = opcion4;
}
}
