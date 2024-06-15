package io.keepcoding.keeptrivial;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

import io.keepcoding.clas.Equipo;
import io.keepcoding.clas.Pregunta;
 
public class MainTrivial {
	private static List<Equipo> equipos = new ArrayList<>();
	//El codigo Main que se ejecutara
	public static void main(String [] args) {
		//Lugar donde esta la lista de preguntas 
		 ArrayList<Pregunta> preguntas = getQuestions();
		//Bucle do while que nos serviria para que el usuario cree varios equipos
		Scanner scanner = new Scanner(System.in);
		String letra = "";
		do {
			System.out.println("Ingresa el nombre de tu equipo: ");
			String nombre = scanner.nextLine();
			Equipo equipo = new Equipo(nombre,0);
			equipos.add(equipo);
			System.out.println("Si deseas terminar de la configuracion de los equipos presion q ");
			letra = scanner.nextLine();
			 letra = letra.toLowerCase();
		}while(letra.equals("q"));
		
		
		boolean exit = false;
		String equipoGanador = "";
		do {
			
			//Iteracion de los equipos 
			for(Equipo equipo:equipos) {
				System.out.println("Turno del equipo: " + equipo.getNameEquipo());
			//Pregunta aleatoria 
			Pregunta pregunta = preguntas.get(getRandomInt(preguntas.size()));
			// Mostrar preguntas
			 System.out.println("Pregunta: " + pregunta.getTituloPregunta());
			    System.out.println("Opciones:");
			    System.out.println("1. " + pregunta.getOpcion1());
			    System.out.println("2. " + pregunta.getOpcion2());
			    System.out.println("3. " + pregunta.getOpcion3());
			    System.out.println("4. " + pregunta.getOpcion4());
			    //Verificacion de las respuestas 
			    System.out.println("Ingrese el número de la opción correcta:");
                int respuestaUsuario = -1;
                while (respuestaUsuario == -1) {
                    try {
                        respuestaUsuario = scanner.nextInt();
                        if (respuestaUsuario < 1 || respuestaUsuario > 4) {
                            System.out.println("Ingrese un número válido (1-4):");
                            respuestaUsuario = -1;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese un número válido (1-4):");
                        scanner.next(); // Limpiar el buffer del scanner
                    }
                }
			// Mostrar resultado
                if (respuestaUsuario == pregunta.getRespuestaCorrecta()) {
                    equipo.incrementarPuntuacion();
                    System.out.println("Respuesta correcta. ¡Bien hecho!");
                } else {
                    System.out.println("Respuesta incorrecta. ¡Sigue intentando!");
                }
                System.out.println("Puntaje actual del equipo " + equipo.getNameEquipo() + ": " + equipo.getPuntuacionEquipos());
                int puntuacion = equipo.getPuntuacionEquipos();
			// Comprobar si hay ganador
                if(puntuacion == 6) {
                	equipoGanador = equipo.getNameEquipo();
                	exit = true;
                }
			// Mostrar clasificación
			}
		} while(!exit);
		System.out.println("Clasificación final:");
		for (Equipo equipo : equipos) {
		    System.out.println(equipo.getNameEquipo() + ": " + equipo.getPuntuacionEquipos() + " puntos");
		}
		System.out.println();
		System.out.println("El equipo ganador es : " + equipoGanador);
		
		
		
		
	}
	public static void title(String text) {
		int length = text.length();
		printHashtagLine(length + 4); // Bordes

        System.out.println("# " + text + " #");

        printHashtagLine(length + 4);
	}
	
	
	public static void printHashtagLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
	
	 public static boolean esTransformableAEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	private static int getRandomInt(int max) {
		return new Random().nextInt(max);
	}
	
	// funcion para poder buscar los archivos.txt
	private static ArrayList<Pregunta> getQuestions() {
		ArrayList<Pregunta>list = new ArrayList<>();
	
		 File folder = new File("questions");
	        if (!folder.exists()) {
	            title("Error al cargar el fichero");
	        } else {
	        	File[] filesList = folder.listFiles();

	            for (File file : filesList) {
	                if (file.isFile() && file.getName().endsWith(".txt")) {
	                    var topicName = file.getName().substring(0, file.getName().length() - 4);
	                    // TODO create topic
	                   System.out.println("Topic Name: " + topicName);

	                    // Read the question
	                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	                        String line;
	                        List<String> block = new ArrayList<>();

	                        while ((line = br.readLine()) != null) {
                        		block.add(line);

	                            if (block.size() == 6) { // número de lineas que componen una pregunta
	                                var question = block.get(0);
	                                var answer1 = block.get(1);
	                                var answer2 = block.get(2);
	                                var answer3 = block.get(3);
	                                var answer4 = block.get(4);
	                                var rightOption = Integer.parseInt(block.get(5));
	                                Pregunta pregunta = new Pregunta(question,answer1,answer2,answer3,answer4,rightOption);
	                                list.add(pregunta);
	                                block.clear();
	                            }
	                        }
	                        // TODO Add to list
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                  
	                }
	            }
	        }
	        
		return list;
	}
	
}
