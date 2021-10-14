package Pratica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ler_Arquivo {

	
	public static GRAPH Recolher_Informacoes(String file) {
		
		GRAPH gh = null;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String value = br.readLine();
			
			gh = new GRAPH(Integer.parseInt(value));
			
			System.out.println("Total de Vertices: " + value + "\n");

			value = br.readLine();
			
			
			while (value != null) {
				String[] vertex = value.split(" ");

				System.out.println(vertex[0] + " " + vertex[1]);
				gh.addEdge(Integer.parseInt(vertex[0]), Integer.parseInt(vertex[1]));

				value = br.readLine();
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return gh;
	}

}