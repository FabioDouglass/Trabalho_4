package Pratica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escrever_Arquivo {
	
	
	public static void TESTAGEM(GRAPH gh, String file) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			bw.write("Vertices: " + gh.Vertices() + "\nArestas: " + gh.Arestas());
			bw.write("\nGrau M�ximo: " + gh.GrauM�ximo() + "\nGrau M�nimo: " + gh.GrauMinimo() + "\nGrau M�dio: " + gh.GrauMedio());
			 
			System.out.println("\nVertices: " + gh.Vertices() + "\nArestas: " + gh.Arestas());
			System.out.println("Grau M�ximo: " + gh.GrauM�ximo() + "\nGrau M�nimo: " + gh.GrauMinimo() + "\nGrau M�dio: " + gh.GrauMedio());
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}