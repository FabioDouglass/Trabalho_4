package Pratica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Grafos_Arquivos {

	
	public static void main(String[] args) {
		
		GRAPH gh = Ler_Arquivo.Recolher_Informacoes("Grafo_1.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Projetar_Grafo.CriarGrafo(gh);	
	 
		 try {	 
		   
			System.out.println("\nDigite a raiz do grafo");   
			String raiz = br.readLine(); 
			
			Projetar_Grafo.Exportar_Pdf(gh, Integer.parseInt(raiz));
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
		Escrever_Arquivo.TESTAGEM(gh, "Informações_Grafo.txt"); 
	}

}